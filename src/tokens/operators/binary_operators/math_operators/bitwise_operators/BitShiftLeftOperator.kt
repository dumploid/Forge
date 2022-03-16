package tokens.operators.binary_operators.math_operators.bitwise_operators

object BitShiftLeftOperator : BitwiseOperator() {
    override val matchedPattern = Regex("<<")
}