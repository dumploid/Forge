package tokens.patterns.operators.binary_operators.comparison_operators

object GreaterThan : ComparisonOperator() {
    override val matchedPattern = Regex(">")
}