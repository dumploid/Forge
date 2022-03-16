package tokens.operators.binary_operators.math_operators.bitwise_operators

object BitwiseXor : BitwiseOperator() {
    override val matchedPattern = Regex("\\^")
}