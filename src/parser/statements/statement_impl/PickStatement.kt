package parser.statements.statement_impl

import environment.type.VariableInstance
import interpreter
import parser.nodes.ASTNode
import parser.nodes.ASTNodeValue
import parser.statements.Statement
import parser.statements.statement_patterns.PickStatementPattern

class PickStatement(nodes: List<ASTNode>): Statement(PickStatementPattern, nodes){
    private val assignedVariableName = (nodes[1].heldValue as ASTNodeValue.EvaluatedValue).evaluatedValue.value
    private val pickedIndex = nodes[2]

    override fun run() {
        val index = interpreter.stack.size - pickedIndex.evaluate<Int>() - 1

        interpreter.variableSpace.insertValue(
            VariableInstance(interpreter.stack[index]),
            assignedVariableName
        )
    }
}