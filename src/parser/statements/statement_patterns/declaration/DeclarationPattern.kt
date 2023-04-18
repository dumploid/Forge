package parser.statements.statement_patterns.declaration

import parser.statements.statement_patterns.StatementPattern
import parser.structure.TokenGroupingPattern
import parser.structure.TokenStructurePattern
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.UnfixedOperatorPattern
import utils.patterns.Pattern

abstract class DeclarationPattern(
    typeName: Pattern<*>,
    assignedValue: Pattern<*>
) : StatementPattern() {
    override val tokenPattern: TokenStructurePattern = TokenGroupingPattern(
        typeName,
        ValidName,
        UnfixedOperatorPattern.ASSIGNMENT_OPERATOR,
        assignedValue
    )
}