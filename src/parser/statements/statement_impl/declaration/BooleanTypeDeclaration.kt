package parser.statements.statement_impl.declaration

import environment.type.VariableInstance
import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.declaration.BooleanTypeDeclarationPattern

class BooleanTypeDeclaration(nodes: List<ASTNode>) : Statement(BooleanTypeDeclarationPattern, nodes) {
    private val name = nodes[1].heldValue.value
    private val evaluatedNode = nodes[3]

    override fun run() {
        interpreter.variableSpace
            .insertValue(VariableInstance(evaluatedNode.evaluate<Boolean>()), name)
    }
}