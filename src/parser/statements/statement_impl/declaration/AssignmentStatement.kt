package parser.statements.statement_impl.declaration

import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.AssignmentStatementPattern

class AssignmentStatement(nodes: List<ASTNode>): Statement(AssignmentStatementPattern, nodes){
    private val name = nodes[0].heldValue.value
    private val evaluatedNode = nodes[2]

    override fun run() {
        interpreter.variableSpace.getVariable(name).value = evaluatedNode.evaluate()
    }
}