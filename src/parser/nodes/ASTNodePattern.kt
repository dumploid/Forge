package parser.nodes

import tokens.patterns.TokenPattern
import utils.patterns.Pattern

class ASTNodePattern(val matchedNodePattern: List<NodeType>) :
    Pattern<List<ASTNode>> {
    init {
        if (matchedNodePattern.none {
                it is NodeType.RootSpecific
            }) throw RuntimeException("No root found for node")
    }

    override fun matches(checkedValue: List<ASTNode>): Boolean {
        if (checkedValue.size != matchedNodePattern.size) return false
        for (i in checkedValue.indices) {
            when (val currentASTNodePattern = matchedNodePattern[i]) {
                is NodeType.NonSpecific -> continue
                is NodeType.Specific -> if (currentASTNodePattern.tokenPattern != checkedValue[i].heldValue.type) return false
                is NodeType.RootSpecific -> {
                    if (currentASTNodePattern.tokenPattern != checkedValue[i].heldValue.type) return false
                    if (checkedValue[i].children.isNotEmpty()) return false
                }
            }
        }

        return true
    }
}

sealed class NodeType {
    data class RootSpecific(val tokenPattern: TokenPattern) : NodeType() //Root of the current AST pattern
    data class Specific(val tokenPattern: TokenPattern) : NodeType()
    object NonSpecific : NodeType()
}