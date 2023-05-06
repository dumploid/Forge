package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword
import tokens.patterns.operators.UnfixedOperatorPattern

object IfStatementPattern : StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(Keyword.IF_KEYWORD),
            NodeType.NonSpecific,
            NodeType.Specific(UnfixedOperatorPattern.OPENING_BRACE)
        )
    )
)