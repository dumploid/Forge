package parser.statements.statement_impl.declaration

import environment.type.VariableInstance
import interpreter
import parser.nodes.ASTNode
import parser.nodes.ASTNodeValue
import parser.statements.Statement
import parser.statements.statement_patterns.IntTypeDeclarationPattern


class IntTypeDeclarationStatement(nodes: List<ASTNode>) : Statement(IntTypeDeclarationPattern, nodes) {
    private val name = (nodes[1].heldValue as ASTNodeValue.EvaluatedValue).evaluatedValue.value
    private val evaluatedNode = nodes[3]

    override fun run() {
        interpreter.variableSpace.insertValue(VariableInstance(evaluatedNode.evaluate<Int>()), name)
    }
}