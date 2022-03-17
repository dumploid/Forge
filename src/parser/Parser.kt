package parser

import parser.nodes.StatementContainer
import parser.statements.statement_patterns.StatementPattern
import parser.statements.statement_patterns.StatementPatternImpl.statementPatternList
import parser.structure.TokenGrouping
import tokens.TokenValue
import tokens.non_specific.StatementEndToken

typealias TokenValueList = List<TokenValue>

object Parser {
    fun parseTokenList(inputTokens: TokenValueList): StatementContainer = StatementContainer(parseStatements(inputTokens))

    fun parseStatements(inputTokens: TokenValueList): List<StatementPattern> {
        val patternList: List<StatementPattern> = getUnparsedStatements(inputTokens).map {
            x ->

            val possibleStatement: StatementPattern = statementPatternList.find {
                it.matchesStatement(TokenGrouping(*x.map{ y -> y.type }.toTypedArray()))
            } ?: throw RuntimeException("Unable to match statement: $x to pattern")

            //throw statement needs to be redone once errors are implemented

            possibleStatement
        }

        return patternList
    }

    fun getUnparsedStatements(inputTokens: TokenValueList): List<TokenValueList> {
        val output: MutableList<TokenValueList> = ArrayList()

        var currentTokenValueList: MutableList<TokenValue> = ArrayList()

        for(currentToken: TokenValue in inputTokens) {
            if(currentToken.type == StatementEndToken) {
                output.add(currentTokenValueList)
                currentTokenValueList = ArrayList()
                continue
            }

            currentTokenValueList.add(currentToken)
        }

        return output
    }
}