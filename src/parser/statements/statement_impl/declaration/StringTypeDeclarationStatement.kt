package parser.statements.statement_impl.declaration

import environment.VariableSpace
import environment.type.VariableInstance
import parser.statements.Statement
import parser.statements.statement_patterns.declaration.StringTypeDeclarationPattern
import tokens.TokenValue
import tokens.patterns.values.immutable_values.StringTokenPattern

class StringTypeDeclarationStatement(tokens: List<TokenValue>) : Statement(StringTypeDeclarationPattern, tokens) {
    private val name = tokens[1].value;
    private val evaluatedNode = tokens[3];

    override fun run() {
        val x = when (evaluatedNode.type) {
            is StringTokenPattern -> (evaluatedNode.type).evaluate(evaluatedNode.value)
            else -> throw RuntimeException("Unable to evaluate node: $evaluatedNode")
        }

        VariableSpace.currentBlock().insertValue(VariableInstance(x), name)
    }
}