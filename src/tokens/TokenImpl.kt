package tokens

import tokens.patterns.keywords.KeywordImpl.keywordList
import tokens.patterns.non_specific.*

import tokens.patterns.operators.*
import tokens.patterns.operators.binary_operators.comparison_operators.*
import tokens.patterns.operators.binary_operators.logical_operators.*
import tokens.patterns.operators.binary_operators.math_operators.*
import tokens.patterns.operators.binary_operators.math_operators.bitwise_operators.*

import tokens.patterns.values.immutable_values.primitive_values.*
import tokens.patterns.values.immutable_values.*

object TokenImpl {
    val tokenList: List<PrecedenceGroup> = listOf(
        PrecedenceGroup(StringTokenPattern),
        PrecedenceGroup(IgnoredTokenPattern),
        PrecedenceGroup(IntTokenPattern),

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
        PrecedenceGroup(StatementEndTokenPattern)
    )
}