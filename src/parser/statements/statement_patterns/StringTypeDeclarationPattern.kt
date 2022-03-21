package parser.statements.statement_patterns

import parser.structure.TokenGrouping
import parser.structure.TokenStructure
import tokens.patterns.keywords.StringKeyword
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.AssignmentOperator
import tokens.patterns.values.immutable_values.StringTokenPattern

object StringTypeDeclarationPattern : StatementPattern() {
    override val tokenPattern: TokenStructure = TokenGrouping(
        StringKeyword,
        ValidName,
        AssignmentOperator,
        StringTokenPattern
    )
}