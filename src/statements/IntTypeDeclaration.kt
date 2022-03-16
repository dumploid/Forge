package statements

import tokens.keywords.built_in_types.*
import tokens.non_specific.ValidName
import tokens.operators.AssignmentOperator
import tokens.structure.*
import tokens.values.immutable_values.primitive_values.IntToken

object IntTypeDeclaration : Statement(TokenGrouping(InterchangeableTokens(IntKeyword, LongKeyword, ShortKeyword, ByteKeyword), ValidName, AssignmentOperator, IntToken)) {
    override fun runStatement() {
        
    }

}