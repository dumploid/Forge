package parser.statements

import parser.statements.statement_impl.declaration.*
import parser.statements.statement_patterns.declaration.*
import tokens.TokenValue

object StatementFactory {
    fun createStatement(inputTokens : List<TokenValue>): Statement = when {
        IntTypeDeclarationPattern.matches(inputTokens) -> IntTypeDeclarationStatement(inputTokens)
        StringTypeDeclarationPattern.matches(inputTokens) -> StringTypeDeclarationStatement(inputTokens)

        else -> throw RuntimeException("Unable to create statement of order: " + inputTokens.map{
            it.type::class.simpleName
        })
    }
}