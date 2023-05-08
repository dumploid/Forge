package parser.statements.statement_impl

import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.EndStatementPattern

class EndStatement(nodes: List<ASTNode>): Statement(EndStatementPattern, nodes){
    override fun run() {
        println("\nCode finished successfully")
    }
}