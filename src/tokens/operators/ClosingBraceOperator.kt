package tokens.operators

object ClosingBraceOperator  : Operator()  {
    override val matchedPattern: Regex = Regex("}")
}