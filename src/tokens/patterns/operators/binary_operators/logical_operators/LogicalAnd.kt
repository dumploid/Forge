package tokens.patterns.operators.binary_operators.logical_operators

object LogicalAnd : LogicalOperator() {
    override val matchedPattern = Regex("&&")
}