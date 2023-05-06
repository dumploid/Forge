package parser.statements.statement_patterns

import parser.nodes.ASTNode
import parser.nodes.ASTNodePattern
import utils.patterns.Pattern

abstract class StatementPattern(val matchedPattern: ASTNodePattern) : Pattern<List<ASTNode>> {
    override fun matches(checkedValue: List<ASTNode>): Boolean = matchedPattern.matches(checkedValue)
}