package tokens

import tokens.patterns.TokenPattern
import utils.patterns.PrecedenceGroup

class TokenPrecedenceGroup(private vararg val tokenPatternGroup: TokenPattern) : PrecedenceGroup<String, TokenPattern> {

    override fun containsMatchingValue(comparedValue: String): Boolean =
        tokenPatternGroup.any {
            it.matchedPattern.containsMatchIn(comparedValue)
        }

    override fun getMatchingValue(comparedValue: String): TokenPattern =
        tokenPatternGroup.find { it.matchedPattern.containsMatchIn(comparedValue) }!!

    fun getTokenValues(comparedString: String): List<TokenValue> {
        val matchedTokenPattern: TokenPattern = getMatchingValue(comparedString)

        val output: MutableList<TokenValue> = ArrayList()

        matchedTokenPattern.matchedPattern.findAll(comparedString).forEach {
            output.add(TokenValue(matchedTokenPattern, it.value))
        }

        return output
    }
}