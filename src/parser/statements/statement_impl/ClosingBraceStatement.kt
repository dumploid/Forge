package parser.statements.statement_impl

import interpreter
import parser.statements.Statement
import parser.statements.statement_patterns.ClosingBracePattern
import tokens.TokenValue

class ClosingBraceStatement(tokens: List<TokenValue>): Statement(ClosingBracePattern, tokens){
    override fun run() {
        interpreter.variableSpace.blocks.removeLast()
    }
}