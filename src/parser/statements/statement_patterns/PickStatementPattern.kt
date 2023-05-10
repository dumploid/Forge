package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.Keyword
import tokens.patterns.non_specific.ValidName

object PickStatementPattern: StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(Keyword.PICK_KEYWORD),
            NodeType.Specific(ValidName),
            NodeType.NonSpecific
        )
    )
)