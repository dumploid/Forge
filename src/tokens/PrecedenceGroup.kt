package tokens

class PrecedenceGroup(private vararg val tokenGroup: Token) {

    fun containsMatchingToken(comparedString: String): Boolean {
        return tokenGroup.any { it.matchedPattern.containsMatchIn(comparedString) }
    }

    fun getMatchedToken(comparedString: String): Token {
        return tokenGroup.find{ it.matchedPattern.containsMatchIn(comparedString) }!!
    }

    fun getTokenValues(comparedString: String): List<TokenValue> {
        val matchedToken: Token = getMatchedToken(comparedString)

        val output: MutableList<TokenValue> = ArrayList()

        matchedToken.matchedPattern.findAll(comparedString).forEach {
            output.add(TokenValue(matchedToken, it.value))
        }

        return output
    }
}