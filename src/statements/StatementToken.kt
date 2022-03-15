package statements

import tokens.Token

abstract class StatementToken() : Token() {
    abstract fun parseStatement(inputString : String): List<Token>
}