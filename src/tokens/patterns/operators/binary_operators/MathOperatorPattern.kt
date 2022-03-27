package tokens.patterns.operators.binary_operators

enum class MathOperatorPattern(override val matchedPattern: Regex) : BinaryOperatorPattern {
    PLUS_OPERATOR(Regex("\\+")),
    MINUS_OPERATOR(Regex("-")),
    MULTIPLY_OPERATOR(Regex("\\*")),
    DIVIDE_OPERATOR(Regex("/")),
    MODULUS_OPERATOR(Regex("%"));
}