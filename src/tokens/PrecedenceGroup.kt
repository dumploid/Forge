package tokens

import tokens.patterns.TokenPattern

class PrecedenceGroup(private vararg val tokenPatternGroup: TokenPattern) {

    fun containsMatchingToken(comparedString: String): Boolean {
        return tokenPatternGroup.any { it.matchedPattern.containsMatchIn(comparedString) }
    }

    fun getMatchedToken(comparedString: String): TokenPattern {
        return tokenPatternGroup.find { it.matchedPattern.containsMatchIn(comparedString) }!!
    }

    fun getTokenValues(comparedString: String): List<TokenValue> {
        val matchedTokenPattern: TokenPattern = getMatchedToken(comparedString)

        val output: MutableList<TokenValue> = ArrayList()

        matchedTokenPattern.matchedPattern.findAll(comparedString).forEach {
            output.add(TokenValue(matchedTokenPattern, it.value))
        }

        return output
    }
}