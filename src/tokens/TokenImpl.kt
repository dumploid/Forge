package tokens

import tokens.patterns.non_specific.*
import tokens.patterns.operators.*
import tokens.patterns.operators.binary_operators.*
import tokens.patterns.values.immutable_values.StringTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.*

val tokenList: List<TokenPrecedenceGroup> = listOf(
    TokenPrecedenceGroup(StringTokenPattern, CharacterTokenPattern),
    TokenPrecedenceGroup(BooleanTokenPattern),
    TokenPrecedenceGroup(IgnoredTokenPattern),
    TokenPrecedenceGroup(DoubleTokenPattern),
    TokenPrecedenceGroup(IntTokenPattern),

    TokenPrecedenceGroup(ValidName), // Also handles keywords later in the clean tokens stage

    TokenPrecedenceGroup(
        ComparisonOperatorPattern.EQUALS,
        ComparisonOperatorPattern.GREATER_THAN_OR_EQUAL,
        ComparisonOperatorPattern.LESS_THAN_OR_EQUAL
    ),
    TokenPrecedenceGroup(LogicalOperatorPattern.LOGICAL_OR, LogicalOperatorPattern.LOGICAL_AND),

    TokenPrecedenceGroup(UnaryOperators.UNARY_NOT, UnaryOperators.UNARY_BITWISE_NOT),

    TokenPrecedenceGroup(
        UnfixedOperatorPattern.OPENING_BRACE,
        UnfixedOperatorPattern.CLOSING_BRACE,
        UnfixedOperatorPattern.OPENING_BRACKET,
        UnfixedOperatorPattern.CLOSING_BRACKET
    ),

    TokenPrecedenceGroup(BitwiseOperators.BITWISE_SHIFT_LEFT, BitwiseOperators.BITWISE_SHIFT_RIGHT),
    TokenPrecedenceGroup(*MathOperatorPattern.values()),
    TokenPrecedenceGroup(BitwiseOperators.BITWISE_AND, BitwiseOperators.BITWISE_OR, BitwiseOperators.BITWISE_XOR),

    TokenPrecedenceGroup(ComparisonOperatorPattern.GREATER_THAN, ComparisonOperatorPattern.LESS_THAN),
    TokenPrecedenceGroup(UnfixedOperatorPattern.ASSIGNMENT_OPERATOR),
    TokenPrecedenceGroup(StatementEndTokenPattern, ColonTokenPattern)
)