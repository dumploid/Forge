package parser.statements.statement_patterns

import parser.structure.TokenGroupingPattern
import parser.structure.TokenStructurePattern
import tokens.patterns.operators.UnfixedOperatorPattern

object ClosingBracePattern : StatementPattern()  {
    override val tokenPattern: TokenStructurePattern = TokenGroupingPattern(
        UnfixedOperatorPattern.CLOSING_BRACE
    )
}