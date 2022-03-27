package tokens.patterns.operators.binary_operators

enum class ComparisonOperatorPattern(override val matchedPattern: Regex) : BinaryOperatorPattern {
    EQUALS(Regex("==")),
    GREATER_THAN(Regex(">")),
    LESS_THAN(Regex("<")),
    GREATER_THAN_OR_EQUAL(Regex(">=")),
    LESS_THAN_OR_EQUAL(Regex("<="));
}