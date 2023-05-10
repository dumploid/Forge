package parser.statements.statement_impl

import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.PutStatementPattern

class PutStatement(nodes: List<ASTNode>): Statement(PutStatementPattern, nodes){
    private val assignedValue = nodes[1]
    private val putIndex = nodes[2]

    override fun run() {
        val index = interpreter.stack.size - putIndex.evaluate<Int>() - 1
        interpreter.stack[index] = assignedValue.evaluate()
    }
}