package parser.statements.statement_impl

import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.PushStatementPattern

class PushStatement(nodes: List<ASTNode>): Statement(PushStatementPattern, nodes){
    private val evaluatedNode = nodes[1]

    override fun run() {
        interpreter.stack.add(evaluatedNode.evaluate())
    }
}