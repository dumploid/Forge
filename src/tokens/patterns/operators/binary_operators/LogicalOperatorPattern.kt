package tokens.patterns.operators.binary_operators

enum class LogicalOperatorPattern(override val matchedPattern: Regex) : BinaryOperatorPattern {
    LOGICAL_OR(Regex("\\|\\|")),
    LOGICAL_AND(Regex("&&"));
}