package tokens.patterns

enum class Keyword(keywordString: String) : TokenPattern {
    BOOLEAN_KEYWORD("Boolean"),
    BYTE_KEYWORD("Byte"),
    CHAR_KEYWORD("Char"),
    DOUBLE_KEYWORD("Double"),
    FLOAT_KEYWORD("Float"),
    INT_KEYWORD("Int"),
    LONG_KEYWORD("Long"),
    SHORT_KEYWORD("Short"),
    STRING_KEYWORD("String"),
    IF_KEYWORD("if");

    init {
        if (!keywordString.matches(Regex("[a-zA-Z_][a-zA-Z_0-9]*"))) {
            throw Exception("Keyword does not match defined patterns")
        }
    }

    override val matchedPattern = Regex(keywordString)

}