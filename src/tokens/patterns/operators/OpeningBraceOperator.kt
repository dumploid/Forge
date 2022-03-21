package tokens.patterns.operators

object OpeningBraceOperator : Operator() {
    override val matchedPattern: Regex = Regex("\\{")
}