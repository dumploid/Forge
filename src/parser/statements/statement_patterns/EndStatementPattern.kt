package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword

object EndStatementPattern : StatementPattern(
    ASTNodePattern(
        listOf(NodeType.RootSpecific(Keyword.END_KEYWORD))
    )
)