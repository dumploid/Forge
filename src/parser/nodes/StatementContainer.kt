package parser.nodes

import parser.statements.Statement

class StatementContainer(val heldStatements: List<Statement>) : AbstractSyntaxTreeNode<List<Statement>>() {
    override fun matches(checkedValue: List<Statement>): Boolean {

        TODO("Not yet implemented")
    }
}