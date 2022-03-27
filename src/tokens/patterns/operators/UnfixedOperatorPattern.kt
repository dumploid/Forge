package tokens.patterns.operators

enum class UnfixedOperatorPattern(override val matchedPattern: Regex) : OperatorTokenPattern {
    ASSIGNMENT_OPERATOR(Regex("=")),
    OPENING_BRACE(Regex("\\{")),
    CLOSING_BRACE(Regex("}")),
    OPENING_BRACKET(Regex("\\[")),
    CLOSING_BRACKET(Regex("]"));
}