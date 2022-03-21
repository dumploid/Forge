package tokens.patterns.operators

object AssignmentOperator : Operator() {
    override val matchedPattern: Regex = Regex("=")

}