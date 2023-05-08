package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword

object PrintStatementPattern : StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(Keyword.PRINT_KEYWORD),
            NodeType.NonSpecific,
        )
    )
)