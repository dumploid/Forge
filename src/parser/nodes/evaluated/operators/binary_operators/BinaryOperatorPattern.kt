package parser.nodes.evaluated.operators.binary_operators

import parser.nodes.evaluated.operators.OperatorNodePattern
import parser.structure.TokenGroupingPattern
import tokens.patterns.operators.OperatorTokenPattern
import utils.patterns.Pattern

abstract class BinaryOperatorPattern(
    val left: Pattern<*>,
    operatorToken: OperatorTokenPattern,
    val right: Pattern<*>
) : OperatorNodePattern(operatorToken) {
    override fun matches(checkedValue: Pattern<*>): Boolean {
        return TokenGroupingPattern(left, operatorToken, right).matches(checkedValue)
    }

    override fun getPatternLength(): Int = 3
}