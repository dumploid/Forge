package parser.statements

import parser.nodes.ASTNode
import parser.statements.statement_impl.*
import parser.statements.statement_impl.declaration.*
import parser.statements.statement_patterns.*
import parser.statements.statement_patterns.declaration.*

object StatementFactory {
    fun createStatement(inputNodes: List<ASTNode>): Statement = when {
        IntTypeDeclarationPattern.matches(inputNodes) -> IntTypeDeclarationStatement(inputNodes)

        DoubleTypeDeclarationPattern.matches(inputNodes) -> DoubleTypeDeclarationStatement(inputNodes)

        CharTypeDeclarationPattern.matches(inputNodes) -> CharTypeDeclarationStatement(inputNodes)
        StringTypeDeclarationPattern.matches(inputNodes) -> StringTypeDeclarationStatement(inputNodes)

        BooleanTypeDeclarationPattern.matches(inputNodes) -> BooleanTypeDeclaration(inputNodes)

        IfStatementPattern.matches(inputNodes) -> IfStatement(inputNodes)
        ClosingBracePattern.matches(inputNodes) -> ClosingBraceStatement(inputNodes)

        PrintStatementPattern.matches(inputNodes) -> PrintStatement(inputNodes)

        LabelStatementPattern.matches(inputNodes) -> LabelStatement(inputNodes)
        GotoStatementPattern.matches(inputNodes) -> GotoStatement(inputNodes)

        AssignmentStatementPattern.matches(inputNodes) -> AssignmentStatement(inputNodes)
        DropStatementPattern.matches(inputNodes) -> DropStatement(inputNodes)

        PushStatementPattern.matches(inputNodes) -> PushStatement(inputNodes)
        PopStatementPattern.matches(inputNodes) -> PopStatement(inputNodes)

        EndStatementPattern.matches(inputNodes) -> EndStatement(inputNodes)

        else -> throw RuntimeException("Unable to create statement of order: " + inputNodes.map {
            it.heldValue.value
        })
    }
}