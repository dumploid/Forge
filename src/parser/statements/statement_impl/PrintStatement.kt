package parser.statements.statement_impl

import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.PrintStatementPattern

class PrintStatement(nodes: List<ASTNode>): Statement(PrintStatementPattern, nodes){

    private val evaluatedNode = nodes[1]

    override fun run() {
        println(evaluatedNode.evaluate() as Any)
    }
}