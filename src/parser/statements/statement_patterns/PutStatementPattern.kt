package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword

object PutStatementPattern: StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(Keyword.PUT_KEYWORD),
            NodeType.NonSpecific,
            NodeType.NonSpecific
        )
    )
)