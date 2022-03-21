package tokens.patterns.operators.binary_operators.math_operators.bitwise_operators

object BitwiseAnd : BitwiseOperator() {
    override val matchedPattern = Regex("&")
}