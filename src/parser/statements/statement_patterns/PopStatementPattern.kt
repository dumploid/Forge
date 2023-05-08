package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword
import tokens.patterns.non_specific.ValidName

object PopStatementPattern: StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(Keyword.POP_KEYWORD),
            NodeType.Specific(ValidName),
        )
    )
)