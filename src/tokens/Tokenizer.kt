package tokens

import tokens.patterns.Keyword
import tokens.patterns.non_specific.IgnoredTokenPattern
import tokens.patterns.non_specific.ValidName

class Tokenizer(private val program: String) {
    private fun hasTokens(): Boolean = tokenList.any {
        it.containsMatchingValue(program)
    }

    private fun getContainingGroup(): TokenPrecedenceGroup = tokenList.find {
        it.containsMatchingValue(program)
    }!!

    private fun getTokenValues(): List<TokenValue> = getContainingGroup().getCapturedTokenValues(program)

    private fun cleanTokens(input: List<TokenValue>): List<TokenValue> {
        val cleanedTokens = input.filter { it.type != IgnoredTokenPattern }

        return cleanedTokens.map { tokenValue ->
            if (tokenValue.type is ValidName) {
                val keywordIndex = Keyword.values().indexOfFirst { keyword -> keyword.matches(tokenValue.value) }
                if (keywordIndex != -1) TokenValue(Keyword.values()[keywordIndex], tokenValue.value) else tokenValue
            } else {
                tokenValue
            }
        }
    }

    fun tokenize(): List<TokenValue> {
        if (!hasTokens()) return emptyList()

        val capturedTokenValues = getTokenValues()
        if (capturedTokenValues.isEmpty()) return emptyList()

        val output: MutableList<TokenValue> = ArrayList()

        val matchedTokenPattern = getContainingGroup().getMatchingValue(program)
        val splitProgram = program.split(matchedTokenPattern.matchedPattern)

        //interweave the split programs tokens and the capturedTokenValues
        for (i in capturedTokenValues.indices) {
            output.addAll(Tokenizer(splitProgram[i]).tokenize())
            output.add(capturedTokenValues[i])
        }

        output.addAll(Tokenizer(splitProgram.last()).tokenize())

        return cleanTokens(output)
    }
}