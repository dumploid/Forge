package parser.statements

import parser.statements.statement_patterns.StatementPattern
import tokens.TokenValue
import utils.patterns.ValueContainer

abstract class Statement(heldPattern: StatementPattern, heldValue: List<TokenValue>) :
    ValueContainer<StatementPattern, List<TokenValue>>(heldPattern, heldValue) {
    abstract fun run()
}