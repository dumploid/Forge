package tokens.operators

object ClosingBracketOperator : Operator()  {
    override val matchedPattern: Regex = Regex("]")
}