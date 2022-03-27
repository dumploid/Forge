package tokens.patterns.operators.binary_operators

enum class BitwiseOperators(override val matchedPattern: Regex) : BinaryOperatorPattern {
    BITWISE_SHIFT_LEFT(Regex("<<")),
    BITWISE_SHIFT_RIGHT(Regex(">>")),
    BITWISE_AND(Regex("&")),
    BITWISE_OR(Regex("\\|")),
    BITWISE_XOR(Regex("\\^"));
}