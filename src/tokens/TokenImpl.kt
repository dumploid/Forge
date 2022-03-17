package tokens

import tokens.keywords.KeywordImpl.keywordList
import tokens.non_specific.*

import tokens.operators.*
import tokens.operators.binary_operators.comparison_operators.*
import tokens.operators.binary_operators.logical_operators.*
import tokens.operators.binary_operators.math_operators.*
import tokens.operators.binary_operators.math_operators.bitwise_operators.*

import tokens.values.immutable_values.primitive_values.*
import tokens.values.immutable_values.*

object TokenImpl {
    val tokenList: List<PrecedenceGroup> = listOf(
        PrecedenceGroup(StringToken),
        PrecedenceGroup(IgnoredToken),
        PrecedenceGroup(IntToken),

        PrecedenceGroup(*keywordList),
        PrecedenceGroup(ValidName),

        PrecedenceGroup(EqualsOperator, GreaterThanOrEqualOperator, LessThanOrEqualOperator),
        PrecedenceGroup(LogicalOr, LogicalAnd),

        PrecedenceGroup(OpeningBraceOperator, ClosingBraceOperator, OpeningBracketOperator, ClosingBracketOperator),

        PrecedenceGroup(BitShiftLeftOperator, BitShiftRightOperator),
        PrecedenceGroup(PlusOperator, MinusOperator, MultiplyOperator, DivideOperator, ModulusOperator),
        PrecedenceGroup(BitwiseAnd, BitwiseOr, BitwiseXor),

        PrecedenceGroup(GreaterThan, LessThan),
        PrecedenceGroup(AssignmentOperator),
        PrecedenceGroup(StatementEndToken)
    )
}