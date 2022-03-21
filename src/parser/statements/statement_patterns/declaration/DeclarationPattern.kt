package parser.statements.statement_patterns.declaration

import parser.statements.statement_patterns.StatementPattern
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.AssignmentOperator
import parser.structure.*

abstract class DeclarationPattern(typeName : AbstractTokenHolder<*>, assignedValue : AbstractTokenHolder<*>) : StatementPattern() {
    override val tokenPattern: TokenStructure = TokenGrouping(
        typeName,
        ValidName,
        AssignmentOperator,
        assignedValue
    )
}