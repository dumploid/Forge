package statements.primitive_assignments

import tokens.Token
import tokens.keywords.IntKeyword
import tokens.non_specific.ValidName
import tokens.operators.AssignmentOperator
import tokens.values.primitive_values.IntToken
import statements.StatementMatcher
import statements.StatementToken

object IntegerAssignment : StatementToken() {
    override fun parseStatement(inputString: String): List<Token> {
        TODO("Not yet implemented")
    }

    override val matchedPattern = StatementMatcher.matches(IntKeyword, ValidName, AssignmentOperator, IntToken)
}