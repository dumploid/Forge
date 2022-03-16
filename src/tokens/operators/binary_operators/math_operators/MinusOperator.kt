package tokens.operators.binary_operators.math_operators

object MinusOperator : MathOperator() {
    override val matchedPattern = Regex("-")
}