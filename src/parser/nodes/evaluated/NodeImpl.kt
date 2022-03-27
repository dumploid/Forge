package parser.nodes.evaluated

import parser.nodes.NodePrecedenceGroup
import parser.nodes.evaluated.operators.binary_operators.StringAdditionPattern

object NodeImpl {
    val nodeList: List<NodePrecedenceGroup> = listOf(
        NodePrecedenceGroup(StringAdditionPattern)
    )
}