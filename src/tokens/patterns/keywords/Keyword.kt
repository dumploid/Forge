package tokens.patterns.keywords

import tokens.patterns.TokenPattern

abstract class Keyword(keywordString: String) : TokenPattern() {

    init {
        if (!keywordString.matches(Regex("[a-zA-Z_][a-zA-Z_0-9]*"))) {
            throw Exception("Keyword does not match defined patterns")
        }
    }

    override val matchedPattern = Regex(keywordString)

}