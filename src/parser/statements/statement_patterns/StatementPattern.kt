package parser.statements.statement_patterns

import parser.structure.TokenGroupingPattern
import parser.structure.TokenStructurePattern
import tokens.TokenValue
import utils.patterns.Pattern

abstract class StatementPattern : Pattern<List<TokenValue>> {
    override fun matches(checkedValue: List<TokenValue>): Boolean {
        val matchedGroup = TokenGroupingPattern(* checkedValue.map { y -> y.type }.toTypedArray())
        if (tokenPattern.matches(matchedGroup)) return true

        return tokenPattern == matchedGroup
    }

    abstract val tokenPattern: TokenStructurePattern
}