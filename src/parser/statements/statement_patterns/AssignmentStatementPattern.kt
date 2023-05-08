package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.UnfixedOperatorPattern

object AssignmentStatementPattern: StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.Specific(ValidName),
            NodeType.RootSpecific(UnfixedOperatorPattern.ASSIGNMENT_OPERATOR),
            NodeType.NonSpecific
        )
    )
)