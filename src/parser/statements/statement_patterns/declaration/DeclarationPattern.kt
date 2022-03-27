package parser.statements.statement_patterns.declaration

import parser.statements.statement_patterns.StatementPattern
import parser.structure.AbstractTokenHolderPattern
import parser.structure.TokenGroupingPattern
import parser.structure.TokenStructurePattern
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.UnfixedOperatorPattern

abstract class DeclarationPattern(
    typeName: AbstractTokenHolderPattern<*>,
    assignedValue: AbstractTokenHolderPattern<*>
) : StatementPattern() {
    override val tokenPattern: TokenStructurePattern = TokenGroupingPattern(
        typeName,
        ValidName,
        UnfixedOperatorPattern.ASSIGNMENT_OPERATOR,
        assignedValue
    )
}