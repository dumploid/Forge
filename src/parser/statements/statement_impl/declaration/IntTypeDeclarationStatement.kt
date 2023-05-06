package parser.statements.statement_impl.declaration

import environment.type.VariableInstance
import interpreter
import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.statement_patterns.declaration.*

class ByteTypeDeclarationStatement(nodes: List<ASTNode>) : Statement(ByteTypeDeclarationPattern, nodes) {
    private val name = nodes[1].heldValue.value
    private val evaluatedNode = nodes[3]

    override fun run() {
        interpreter.variableSpace.currentBlock().insertValue(VariableInstance(evaluatedNode.evaluate(Byte::class)), name)
    }
}

class ShortTypeDeclarationStatement(nodes: List<ASTNode>) : Statement(ShortTypeDeclarationPattern, nodes) {
    private val name = nodes[1].heldValue.value
    private val evaluatedNode = nodes[3]

    override fun run() {
        interpreter.variableSpace.currentBlock().insertValue(VariableInstance(evaluatedNode.evaluate(Short::class)), name)
    }
}

class IntTypeDeclarationStatement(nodes: List<ASTNode>) : Statement(IntTypeDeclarationPattern, nodes) {
    private val name = nodes[1].heldValue.value
    private val evaluatedNode = nodes[3]

    override fun run() {
        interpreter.variableSpace.currentBlock().insertValue(VariableInstance(evaluatedNode.evaluate(Int::class)), name)
    }
}

class LongTypeDeclarationStatement(nodes: List<ASTNode>) : Statement(LongTypeDeclarationPattern, nodes) {
    private val name = nodes[1].heldValue.value
    private val evaluatedNode = nodes[3]

    override fun run() {
        interpreter.variableSpace.currentBlock().insertValue(VariableInstance(evaluatedNode.evaluate(Long::class)), name)
    }
}