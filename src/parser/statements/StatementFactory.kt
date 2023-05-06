package parser.statements

import parser.nodes.ASTNode
import parser.statements.statement_impl.ClosingBraceStatement
import parser.statements.statement_impl.IfStatement
import parser.statements.statement_impl.declaration.*
import parser.statements.statement_patterns.*
import parser.statements.statement_patterns.declaration.*

object StatementFactory {
    fun createStatement(inputNodes: List<ASTNode>): Statement = when {
        ByteTypeDeclarationPattern.matches(inputNodes) -> ByteTypeDeclarationStatement(inputNodes)
        ShortTypeDeclarationPattern.matches(inputNodes) -> ShortTypeDeclarationStatement(inputNodes)
        IntTypeDeclarationPattern.matches(inputNodes) -> IntTypeDeclarationStatement(inputNodes)
        LongTypeDeclarationPattern.matches(inputNodes) -> LongTypeDeclarationStatement(inputNodes)

        FloatTypeDeclarationPattern.matches(inputNodes) -> FloatTypeDeclarationStatement(inputNodes)
        DoubleTypeDeclarationPattern.matches(inputNodes) -> DoubleTypeDeclarationStatement(inputNodes)

        CharTypeDeclarationPattern.matches(inputNodes) -> CharTypeDeclarationStatement(inputNodes)
        StringTypeDeclarationPattern.matches(inputNodes) -> StringTypeDeclarationStatement(inputNodes)

        BooleanTypeDeclarationPattern.matches(inputNodes) -> BooleanTypeDeclaration(inputNodes)

        IfStatementPattern.matches(inputNodes) -> IfStatement(inputNodes)
        ClosingBracePattern.matches(inputNodes) -> ClosingBraceStatement(inputNodes)

        else -> throw RuntimeException("Unable to create statement of order: " + inputNodes.map {
            it.heldValue
        })
    }
}