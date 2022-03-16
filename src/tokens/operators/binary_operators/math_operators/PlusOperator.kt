package tokens.operators.binary_operators.math_operators

object PlusOperator : MathOperator() {
    override val matchedPattern = Regex("\\+")
}