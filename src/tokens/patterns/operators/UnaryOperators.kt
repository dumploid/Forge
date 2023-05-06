package tokens.patterns.operators

enum class UnaryOperators(override val matchedPattern: Regex): OperatorTokenPattern {
    UNARY_NOT(Regex("!")),
    UNARY_BITWISE_NOT(Regex("~"))
}