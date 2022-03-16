package tokens.operators.binary_operators.math_operators.bitwise_operators

object BitwiseOr : BitwiseOperator() {
    override val matchedPattern = Regex("\\|")
}