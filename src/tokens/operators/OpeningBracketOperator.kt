package tokens.operators

object OpeningBracketOperator : Operator() {
    override val matchedPattern: Regex = Regex("\\[")
}