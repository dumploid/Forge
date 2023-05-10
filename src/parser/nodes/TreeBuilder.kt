package parser.nodes

import tokens.patterns.values.immutable_values.StringTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.BooleanTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.CharacterTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.DoubleTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.IntTokenPattern
import java.lang.IllegalStateException

class TreeBuilder(nodes: List<ASTNode>) {
    val nodes = nodes.toMutableList()
    private fun getContainingGroup(precedenceGroups: List<NodePrecedenceGroup>): NodePrecedenceGroup = precedenceGroups.find {
        it.containsMatchingValue(nodes)
    }!!

    fun buildTrees(): List<ASTNode> {
        if (evaluatedNodeList.none { it.containsMatchingValue(nodes) }) return nodes

        val delimiter = getContainingGroup(evaluatedNodeList).getMatchingValue(nodes)
        val delimiterSize = delimiter.matchedNodePattern.size

        //In the future, reduce redundancy of getting delimiter (it looks for the matched delimiter twice).
        for (currentIndex in 0..nodes.size - delimiterSize) {
            val window = nodes.subList(currentIndex, currentIndex + delimiterSize).toMutableList()
            if (delimiter.matches(window)) {
                val replacedNodeIndex = delimiter.matchedNodePattern.indexOfFirst { it is NodeType.RootSpecific }

                val replacedNode = window[replacedNodeIndex]
                val replacedNodeChildren = window.filter { x -> x != replacedNode }

                nodes.subList(currentIndex + 1, currentIndex + delimiterSize).clear()
                nodes[currentIndex] = ASTNode(replacedNode.heldValue, replacedNodeChildren)

                return TreeBuilder(nodes).buildTrees()
            }
        }

        throw IllegalStateException("Required $delimiter to match to nodes")
    }
}

fun cleanNode(inputNode: ASTNode): ASTNode {
    val nodeValue = (inputNode.heldValue as ASTNodeValue.EvaluatedValue).evaluatedValue
    return ASTNode(
        when (nodeValue.type) {
            is IntTokenPattern -> {
                val from = nodeValue.value
                val radix = when {
                    from.startsWith("0b") -> 2
                    from.startsWith("0o") -> 8
                    from.startsWith("0x") -> 16
                    else -> 10
                }

                ASTNodeValue.IntegerValue(
                    if (radix != 10) {
                        from.drop(2)
                    } else {
                        from
                    }.toInt(radix)
                )
            }

            is StringTokenPattern -> {
                val quotedString = nodeValue.value
                ASTNodeValue.StringValue(quotedString.substring(1 until quotedString.length - 1))
            }

            is DoubleTokenPattern -> ASTNodeValue.DoubleValue(nodeValue.value.toDouble())
            is CharacterTokenPattern -> ASTNodeValue.CharValue(nodeValue.value[1])
            is BooleanTokenPattern -> ASTNodeValue.BooleanValue(nodeValue.value == "true")

            else -> {
                inputNode.heldValue
            }
        }, emptyList()
    )
}