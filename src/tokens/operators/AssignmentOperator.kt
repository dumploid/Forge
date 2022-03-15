package tokens.operators

object AssignmentOperator : Operator() {
    override val matchedPattern: Regex = Regex("=")

}