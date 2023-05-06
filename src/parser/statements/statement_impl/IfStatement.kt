package parser.statements.statement_impl

import environment.BlockScope
import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.IfStatementPattern

class IfStatement(nodes: List<ASTNode>): Statement(IfStatementPattern, nodes){

    private val evaluatedNode = nodes[1]

    override fun run() {
        if (evaluatedNode.evaluate(Boolean::class)) {
            interpreter.variableSpace.blocks.add(BlockScope())
        } else {
            interpreter.jumpToClosingBrace()
        }
    }
}