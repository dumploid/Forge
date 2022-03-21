package tokens.patterns.operators.binary_operators.math_operators.bitwise_operators

object BitShiftRightOperator : BitwiseOperator() {
    override val matchedPattern = Regex(">>")
}