package parser.nodes.evaluated.operators.binary_operators

import parser.nodes.evaluated.operators.OperatorNodePattern
import parser.structure.AbstractTokenHolderPattern
import parser.structure.TokenGroupingPattern
import tokens.patterns.operators.OperatorTokenPattern

abstract class BinaryOperatorPattern(
    val left: AbstractTokenHolderPattern<*>,
    operatorToken: OperatorTokenPattern,
    val right: AbstractTokenHolderPattern<*>
) : OperatorNodePattern(operatorToken) {
    override fun matches(checkedValue: AbstractTokenHolderPattern<*>): Boolean {
        return TokenGroupingPattern(left, operatorToken, right).matches(checkedValue)
    }

    override fun getPatternLength(): Int = 3
}