package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword

object PushStatementPattern: StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(Keyword.PUSH_KEYWORD),
            NodeType.NonSpecific
        )
    )
)