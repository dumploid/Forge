package tokens.operators.binary_operators.math_operators

object MultiplyOperator : MathOperator() {
    override val matchedPattern = Regex("\\*")
}