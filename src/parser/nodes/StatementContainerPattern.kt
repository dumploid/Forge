package parser.nodes

import parser.statements.Statement

class StatementContainerPattern(val heldStatements: List<Statement>) : AbstractSyntaxTreeNodePattern<List<Statement>> {
    override fun matches(checkedValue: List<Statement>): Boolean {

        TODO("Not yet implemented")
    }
}