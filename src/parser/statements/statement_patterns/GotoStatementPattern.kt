package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword
import tokens.patterns.non_specific.ValidName

object GotoStatementPattern: StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(Keyword.GOTO_KEYWORD),
            NodeType.Specific(ValidName),
        )
    )
)