package parser.statements

import parser.nodes.ASTNode
import parser.statements.statement_patterns.StatementPattern
import utils.patterns.ValueContainer

abstract class Statement(heldPattern: StatementPattern, heldValue: List<ASTNode>) :
    ValueContainer<StatementPattern, List<ASTNode>>(heldPattern, heldValue) {

    abstract fun run()
}