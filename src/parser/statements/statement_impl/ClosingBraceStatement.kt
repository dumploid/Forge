package parser.statements.statement_impl

import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.ClosingBracePattern

class ClosingBraceStatement(nodes: List<ASTNode>): Statement(ClosingBracePattern, nodes){
    override fun run() {
        interpreter.variableSpace.blocks.removeLast()
    }
}