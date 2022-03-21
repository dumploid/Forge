package tokens.patterns.operators

object ClosingBracketOperator : Operator() {
    override val matchedPattern: Regex = Regex("]")
}