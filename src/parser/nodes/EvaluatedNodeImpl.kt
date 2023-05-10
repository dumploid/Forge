package parser.nodes

import tokens.patterns.operators.binary_operators.ComparisonOperatorPattern
import tokens.patterns.operators.binary_operators.LogicalOperatorPattern
import tokens.patterns.operators.binary_operators.MathOperatorPattern

val evaluatedNodeList: List<NodePrecedenceGroup> = listOf(
    NodePrecedenceGroup(
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(MathOperatorPattern.MODULUS_OPERATOR), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(MathOperatorPattern.MULTIPLY_OPERATOR), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(MathOperatorPattern.DIVIDE_OPERATOR), NodeType.NonSpecific)
        ),
    ),
    NodePrecedenceGroup(
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(MathOperatorPattern.PLUS_OPERATOR), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(MathOperatorPattern.MINUS_OPERATOR), NodeType.NonSpecific)
        ),
    ),
    NodePrecedenceGroup(
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(LogicalOperatorPattern.LOGICAL_OR), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(LogicalOperatorPattern.LOGICAL_AND), NodeType.NonSpecific)
        )
    ),
    NodePrecedenceGroup(
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(ComparisonOperatorPattern.LESS_THAN), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(ComparisonOperatorPattern.LESS_THAN_OR_EQUAL), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(ComparisonOperatorPattern.GREATER_THAN), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(ComparisonOperatorPattern.GREATER_THAN_OR_EQUAL), NodeType.NonSpecific)
        ),
        ASTNodePattern(
            listOf(NodeType.NonSpecific, NodeType.RootSpecific(ComparisonOperatorPattern.EQUALS), NodeType.NonSpecific)
        ),
    )
)