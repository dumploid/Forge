package tokens

import tokens.patterns.Keyword
import tokens.patterns.non_specific.IgnoredTokenPattern
import tokens.patterns.non_specific.StatementEndTokenPattern
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.UnaryOperators
import tokens.patterns.operators.UnfixedOperatorPattern
import tokens.patterns.operators.binary_operators.BitwiseOperators
import tokens.patterns.operators.binary_operators.ComparisonOperatorPattern
import tokens.patterns.operators.binary_operators.LogicalOperatorPattern
import tokens.patterns.operators.binary_operators.MathOperatorPattern
import tokens.patterns.values.immutable_values.StringTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.BooleanTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.CharacterTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.DoubleTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.IntTokenPattern

val tokenList: List<TokenPrecedenceGroup> = listOf(
    TokenPrecedenceGroup(StringTokenPattern, CharacterTokenPattern),
    TokenPrecedenceGroup(DoubleTokenPattern, IntTokenPattern),
    TokenPrecedenceGroup(BooleanTokenPattern),
    TokenPrecedenceGroup(IgnoredTokenPattern),

    TokenPrecedenceGroup(*Keyword.values()),
    TokenPrecedenceGroup(ValidName),

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
    TokenPrecedenceGroup(StatementEndTokenPattern)
)