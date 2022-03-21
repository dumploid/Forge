package parser.statements.statement_impl.declaration

import parser.statements.Statement
import parser.statements.statement_patterns.declaration.IntTypeDeclarationPattern
import tokens.TokenValue

class IntTypeDeclarationStatement(heldValue: List<TokenValue>): Statement(IntTypeDeclarationPattern, heldValue) {
    override fun run() {
        TODO("Not yet implemented")
    }
}