package parser.statements.statement_impl

import interpreter
import parser.nodes.ASTNode
import parser.nodes.ASTNodeValue
import parser.statements.Statement
import parser.statements.statement_patterns.GotoStatementPattern

class GotoStatement(nodes: List<ASTNode>): Statement(GotoStatementPattern, nodes){
    private val labelName = (nodes[1].heldValue as ASTNodeValue.EvaluatedValue).evaluatedValue.value

    override fun run() {
        val searchedName = labelName
        interpreter.goToLabel(searchedName)
    }
}