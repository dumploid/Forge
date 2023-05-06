package tokens

import tokens.patterns.non_specific.IgnoredTokenPattern

class Tokenizer(private val program: String) {
    private fun hasTokens(): Boolean = tokenList.any {
        it.containsMatchingValue(program)
    }

    private fun getContainingGroup(): TokenPrecedenceGroup = tokenList.find {
        it.containsMatchingValue(program)
    }!!

    private fun getTokenValues(): List<TokenValue> = getContainingGroup().getCapturedTokenValues(program)

    private fun cleanTokens(input: List<TokenValue>): List<TokenValue> = input.filter { it.type != IgnoredTokenPattern }

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