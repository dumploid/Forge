package parser.statements.statement_impl

import environment.BlockScope
import interpreter
import parser.statements.Statement
import parser.statements.statement_patterns.IfStatementPattern
import tokens.TokenValue
import tokens.patterns.values.immutable_values.primitive_values.BooleanTokenPattern

class IfStatement(tokens: List<TokenValue>): Statement(IfStatementPattern, tokens){

    private val evaluatedNode = tokens[1]

    override fun run() {
        val runIfStatement = when (evaluatedNode.type) {
            is BooleanTokenPattern -> (evaluatedNode.type).evaluate(evaluatedNode.value)
            else -> throw RuntimeException("Unable to evaluate node: $evaluatedNode")
        }

        if (runIfStatement) {
            interpreter.variableSpace.blocks.add(BlockScope())
        } else {
            interpreter.jumpToClosingBrace()
        }
    }
}