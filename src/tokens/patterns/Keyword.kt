package tokens.patterns

enum class Keyword(keywordString: String) : TokenPattern {
    BOOLEAN_KEYWORD("Boolean"),
    CHAR_KEYWORD("Char"),
    DOUBLE_KEYWORD("Double"),
    INT_KEYWORD("Int"),
    STRING_KEYWORD("String"),
    IF_KEYWORD("if"),
    PRINT_KEYWORD("print"),
    GOTO_KEYWORD("goto"),
    DROP_KEYWORD("drop"),
    PUSH_KEYWORD("push"),
    POP_KEYWORD("pop"),
    PICK_KEYWORD("pick"),
    PUT_KEYWORD("put"),
    END_KEYWORD("end");

    init {
        if (!keywordString.matches(Regex("[a-zA-Z_][a-zA-Z_0-9]*"))) {
            throw Exception("Keyword does not match defined patterns")
        }
    }

    override val matchedPattern = Regex(keywordString)

}