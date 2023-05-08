package parser.statements.statement_impl

import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.LabelStatementPattern

class LabelStatement(nodes: List<ASTNode>): Statement(LabelStatementPattern, nodes){
    val name = nodes[0]
    override fun run() {}
}