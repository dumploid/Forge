package tokens.patterns.operators

object OpeningBracketOperator : Operator() {
    override val matchedPattern: Regex = Regex("\\[")
}