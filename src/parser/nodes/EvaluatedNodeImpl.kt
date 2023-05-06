package parser.nodes

import tokens.patterns.operators.binary_operators.MathOperatorPattern

val evaluatedNodeList: List<NodePrecedenceGroup> = listOf(
    NodePrecedenceGroup(
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(MathOperatorPattern.PLUS_OPERATOR), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(MathOperatorPattern.MINUS_OPERATOR), NodeType.NonSpecific)
        )
    ),
)