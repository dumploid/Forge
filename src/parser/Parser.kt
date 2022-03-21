package parser

import parser.nodes.StatementContainer
import parser.statements.statement_patterns.StatementPattern
import parser.statements.statement_patterns.StatementPatternImpl.statementPatternList
import tokens.TokenValue
import tokens.patterns.non_specific.StatementEndTokenPattern

typealias TokenValueList = List<TokenValue>

object Parser {
    fun parseTokenList(inputTokens: TokenValueList): StatementContainer = TODO()
        //StatementContainer(parseStatements(inputTokens))

    fun parseStatements(inputTokens: TokenValueList): List<StatementPattern> =
        getUnparsedStatements(inputTokens).map { x ->
            statementPatternList.find { y ->
                y.matches(x)
            }!!
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