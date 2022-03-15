package tokens

import tokens.keywords.*
import tokens.non_specific.*
import tokens.operators.*
import tokens.values.primitive_values.*

object TokenImpl {
    val tokenList: List<PrecedenceGroup> = listOf(
        PrecedenceGroup(IntToken),
        PrecedenceGroup(*KeywordImpl.keywordList),
        PrecedenceGroup(ValidName),
        PrecedenceGroup(OpeningBraceOperator, ClosingBraceOperator, OpeningBracketOperator, ClosingBracketOperator),
        PrecedenceGroup(AssignmentOperator)
    )
}