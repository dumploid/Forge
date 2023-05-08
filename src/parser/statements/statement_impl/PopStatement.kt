package parser.statements.statement_impl

import environment.type.VariableInstance
import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.PopStatementPattern

class PopStatement(nodes: List<ASTNode>) : Statement(PopStatementPattern, nodes) {
    private val assignedVariableName = nodes[1]

    override fun run() {
        interpreter.variableSpace.insertValue(
            VariableInstance(interpreter.stack.removeLast()),
            assignedVariableName.heldValue.value
        )
    }
}