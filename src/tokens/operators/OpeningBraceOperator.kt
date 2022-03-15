package tokens.operators

object OpeningBraceOperator : Operator()  {
    override val matchedPattern: Regex = Regex("\\{")
}