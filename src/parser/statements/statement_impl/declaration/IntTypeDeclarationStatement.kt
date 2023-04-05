package parser.statements.statement_impl.declaration

import environment.VariableSpace
import environment.type.IntInstance
import parser.statements.Statement
import parser.statements.statement_patterns.declaration.IntTypeDeclarationPattern
import tokens.TokenValue

class IntTypeDeclarationStatement(heldValue: List<TokenValue>) : Statement(IntTypeDeclarationPattern, heldValue) {
    val heldValues: List<TokenValue> = heldValue

    override fun run() {
        for (x in heldValues) {
            println(x)
        }

        println("Test!")
        VariableSpace.currentBlock().insertValue(IntInstance())
    }
}