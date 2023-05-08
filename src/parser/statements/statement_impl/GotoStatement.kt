package parser.statements.statement_impl

import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.GotoStatementPattern

class GotoStatement(nodes: List<ASTNode>): Statement(GotoStatementPattern, nodes){
    private val labelName = nodes[1]

    override fun run() {
        val searchedName = labelName.heldValue.value
        interpreter.goToLabel(searchedName)
    }
}