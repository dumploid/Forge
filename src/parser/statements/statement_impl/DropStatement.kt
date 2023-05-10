package parser.statements.statement_impl

import interpreter
import parser.nodes.ASTNode
import parser.nodes.ASTNodeValue
import parser.statements.Statement
import parser.statements.statement_patterns.DropStatementPattern

class DropStatement(nodes: List<ASTNode>): Statement(DropStatementPattern, nodes){
    private val name = (nodes[1].heldValue as ASTNodeValue.EvaluatedValue).evaluatedValue.value

    override fun run() {
        interpreter.variableSpace.heldValues.remove(name)
    }
}