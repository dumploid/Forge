package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword
import tokens.patterns.non_specific.ValidName

object DropStatementPattern : StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(Keyword.DROP_KEYWORD),
            NodeType.Specific(ValidName),
        )
    )
)