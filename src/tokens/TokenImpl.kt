package tokens

import tokens.keywords.KeywordImpl.keywordList
import tokens.non_specific.*
import tokens.operators.*
import tokens.values.immutable_values.primitive_values.*
import tokens.values.immutable_values.*

object TokenImpl {
    val tokenList: List<PrecedenceGroup> = listOf(
        PrecedenceGroup(StringToken),
        PrecedenceGroup(IgnoredToken, IntToken),
        PrecedenceGroup(*keywordList),
        PrecedenceGroup(ValidName),
        PrecedenceGroup(OpeningBraceOperator, ClosingBraceOperator, OpeningBracketOperator, ClosingBracketOperator),
        PrecedenceGroup(AssignmentOperator)
    )
}