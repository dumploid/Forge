package parser.nodes

import parser.statements.Statement
import utils.patterns.Pattern

class StatementContainerPattern(val heldStatements: List<Statement>) : Pattern<List<Statement>> {
    override fun matches(checkedValue: List<Statement>): Boolean {

        TODO("Not yet implemented")
    }
}