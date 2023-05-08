package parser.statements.statement_patterns

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import tokens.patterns.non_specific.ColonTokenPattern
import tokens.patterns.non_specific.ValidName

object LabelStatementPattern: StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.RootSpecific(ValidName),
            NodeType.Specific(ColonTokenPattern),
        )
    )
)