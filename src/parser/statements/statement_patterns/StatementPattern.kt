package parser.statements.statement_patterns

import parser.structure.TokenGrouping
import parser.structure.TokenStructure

abstract class StatementPattern(private val tokenPattern: TokenStructure) {
    fun matchesStatement(matchedGroup: TokenGrouping): Boolean = tokenPattern.tokenHolderEquals(matchedGroup)
}