package tokens.patterns.operators

object ClosingBraceOperator : Operator() {
    override val matchedPattern: Regex = Regex("}")
}