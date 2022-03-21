package parser.statements.statement_patterns

import parser.structure.*
import tokens.TokenValue
import tokens.patterns.TokenPattern
import utils.patterns.Pattern

abstract class StatementPattern: Pattern<List<TokenValue>> {
    override fun matches(checkedValue: List<TokenValue>): Boolean {
        val matchedGroup = TokenGrouping(* checkedValue.map { y -> y.type }.toTypedArray())
        return tokenPattern == matchedGroup
    }

    abstract val tokenPattern: TokenStructure
}