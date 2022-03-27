package parser

import parser.nodes.StatementContainerPattern
import parser.statements.Statement
import parser.statements.StatementFactory
import tokens.TokenValue
import tokens.patterns.non_specific.StatementEndTokenPattern

typealias TokenValueList = List<TokenValue>

object Parser {
    fun parseTokenList(inputTokens: TokenValueList): StatementContainerPattern =
        StatementContainerPattern(parseStatements(inputTokens))

    private fun parseStatements(inputTokens: TokenValueList): List<Statement> =
        getUnparsedStatements(inputTokens).map { x ->
            StatementFactory.createStatement(x)
        }

    private fun getUnparsedStatements(inputTokens: TokenValueList): List<TokenValueList> {
        val output: MutableList<TokenValueList> = ArrayList()

        var currentTokenValueList: MutableList<TokenValue> = ArrayList()

        for (currentToken: TokenValue in inputTokens) {
            if (currentToken.type == StatementEndTokenPattern) {
                output.add(currentTokenValueList)
                currentTokenValueList = ArrayList()
                continue
            }

            currentTokenValueList.add(currentToken)
        }

        return output
    }
}