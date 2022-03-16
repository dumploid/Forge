package tokens.operators.binary_operators.comparison_operators

object EqualsOperator : ComparisonOperator() {
    override val matchedPattern = Regex("==")
}