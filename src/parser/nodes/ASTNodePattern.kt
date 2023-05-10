package parser.nodes

import utils.patterns.Pattern

class ASTNodePattern(val matchedNodePattern: List<NodeType>) :
    Pattern<List<ASTNode>> {
    init {
        val rootCount = matchedNodePattern.count{it is NodeType.RootSpecific}
        if (rootCount == 0) throw RuntimeException("No root found for node")
        if (rootCount > 1) throw RuntimeException("Unable to have more than one root per node")
    }

    override fun matches(checkedValue: List<ASTNode>): Boolean {
        if (checkedValue.size != matchedNodePattern.size) return false
        for (i in checkedValue.indices) {

            if (checkedValue[i].heldValue is ASTNodeValue.EvaluatedValue) {
                val checkedNodeValue = (checkedValue[i].heldValue as ASTNodeValue.EvaluatedValue).evaluatedValue
                when (val currentASTNodePattern = matchedNodePattern[i]) {
                    is NodeType.NonSpecific -> continue
                    is NodeType.Specific -> if (currentASTNodePattern.tokenPattern != checkedNodeValue.type) return false
                    is NodeType.RootSpecific -> {
                        if (currentASTNodePattern.tokenPattern != checkedNodeValue.type) return false
                        if (checkedValue[i].children.isNotEmpty()) return false
                    }
                }
            } else {
                if(matchedNodePattern[i] != NodeType.NonSpecific) return false
            }

        }

        return true
    }
}

sealed class NodeType {
    data class RootSpecific(val tokenPattern: Pattern<String>) : NodeType() //Root of the current AST pattern
    data class Specific(val tokenPattern: Pattern<String>) : NodeType()
    object NonSpecific : NodeType()
}