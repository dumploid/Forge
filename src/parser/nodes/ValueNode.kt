package parser.nodes

import tokens.TokenValue

class ValueNode(val heldValue: TokenValue) : AbstractSyntaxTreeNode<TokenValue>() {
    override fun matches(comparedValue: TokenValue): Boolean = comparedValue == heldValue
}