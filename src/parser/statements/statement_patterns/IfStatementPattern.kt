package parser.statements.statement_patterns

import parser.nodes.evaluated.EvaluatedNodeType
import parser.nodes.evaluated.EvaluatedNodeTypeWrapper
import parser.structure.TokenGroupingPattern
import parser.structure.TokenStructurePattern
import tokens.patterns.Keyword
import tokens.patterns.operators.UnfixedOperatorPattern

object IfStatementPattern : StatementPattern() {
    override val tokenPattern: TokenStructurePattern = TokenGroupingPattern(
        Keyword.IF_KEYWORD,
        EvaluatedNodeTypeWrapper(EvaluatedNodeType.BooleanType),
        UnfixedOperatorPattern.OPENING_BRACE,
    )
}