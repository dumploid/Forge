package parser

import parser.nodes.StatementContainerPattern
import parser.statements.Statement
import parser.statements.StatementFactory
import tokens.TokenValue
import tokens.patterns.non_specific.StatementEndTokenPattern
import tokens.patterns.operators.UnfixedOperatorPattern

typealias TokenValueList = List<TokenValue>

object Parser {
    fun parseTokenList(inputTokens: TokenValueList): StatementContainerPattern =
        StatementContainerPattern(parseStatements(inputTokens))

    private fun parseStatements(inputTokens: TokenValueList): List<Statement> =
        getUnparsedStatements(inputTokens).map { x ->
            StatementFactory.createStatement(x)
        }

    private fun isBracket(currentToken: TokenValue): Boolean =currentToken.type == UnfixedOperatorPattern.CLOSING_BRACE ||
                currentToken.type == UnfixedOperatorPattern.OPENING_BRACE

    private fun getUnparsedStatements(inputTokens: TokenValueList): List<TokenValueList> {
        val output: MutableList<TokenValueList> = ArrayList()

        var currentTokenValueList: MutableList<TokenValue> = ArrayList()

        for (currentToken: TokenValue in inputTokens) {
            if (currentToken.type == StatementEndTokenPattern || isBracket(currentToken)) {
                if (isBracket(currentToken)) {
                    currentTokenValueList.add(currentToken)
                }

                output.add(currentTokenValueList)
                currentTokenValueList = ArrayList()
                continue
            }

            currentTokenValueList.add(currentToken)
        }

        return output
    }
}