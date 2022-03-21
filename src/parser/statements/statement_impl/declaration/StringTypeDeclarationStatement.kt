package parser.statements.statement_impl.declaration

import parser.statements.Statement
import parser.statements.statement_patterns.declaration.StringTypeDeclarationPattern
import tokens.TokenValue

class StringTypeDeclarationStatement(heldValue: List<TokenValue>): Statement(StringTypeDeclarationPattern, heldValue) {
    override fun run() {
        TODO("Not yet implemented")
    }
}