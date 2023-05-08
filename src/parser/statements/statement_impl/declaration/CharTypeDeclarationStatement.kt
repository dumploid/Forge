package parser.statements.statement_impl.declaration

import environment.type.VariableInstance
import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.declaration.CharTypeDeclarationPattern

class CharTypeDeclarationStatement(nodes: List<ASTNode>) : Statement(CharTypeDeclarationPattern, nodes) {
    private val name = nodes[1].heldValue.value
    private val evaluatedNode = nodes[3]

    override fun run() {
        interpreter.variableSpace.insertValue(VariableInstance(evaluatedNode.evaluate<Char>()), name)
    }
}