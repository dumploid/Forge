package tokens.patterns.operators.binary_operators.math_operators

object ModulusOperator : MathOperator() {
    override val matchedPattern = Regex("%")
}