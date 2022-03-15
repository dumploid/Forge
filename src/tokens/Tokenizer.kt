package tokens

final class Tokenizer {
    private lateinit var program: String

    private fun hasTokens(): Boolean = TokenImpl.tokenList.any{
                                            it.containsMatchingToken(program)
                                        }

    private fun getContainingGroup(): PrecedenceGroup = TokenImpl.tokenList.find{
                                                            it.containsMatchingToken(program)
                                                        }!!

    private fun getTokenValues(): List<TokenValue> = getContainingGroup().getTokenValues(program)

    fun tokenize(program: String): List<TokenValue> {
        this.program = program
        if(!hasTokens()) return listOf()

        val output: MutableList<TokenValue> = ArrayList()

        val capturedTokenValues = getTokenValues()
        if(capturedTokenValues.isEmpty()) return listOf()

        val matchedToken = getContainingGroup().getMatchedToken(program)
        val splitProgram = program.split(matchedToken.matchedPattern)

        //interweave the split programs tokens and the capturedTokenValues
        for (i in capturedTokenValues.indices) {
            output.addAll(tokenize(splitProgram[i]))
            output.add(capturedTokenValues[i])
        }

        output.addAll(tokenize(splitProgram.last()))

        return output
    }
}