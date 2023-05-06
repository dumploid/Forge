package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.operators.UnfixedOperatorPattern

object ClosingBracePattern : StatementPattern(
    ASTNodePattern(
        listOf(NodeType.RootSpecific(UnfixedOperatorPattern.CLOSING_BRACE))
    )
)