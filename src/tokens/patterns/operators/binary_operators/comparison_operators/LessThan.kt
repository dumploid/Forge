package tokens.patterns.operators.binary_operators.comparison_operators

object LessThan : ComparisonOperator() {
    override val matchedPattern = Regex("<")
}