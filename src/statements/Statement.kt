package statements

import tokens.structure.AbstractTokenHolder

abstract class Statement(val tokenPattern: AbstractTokenHolder) {
    abstract fun runStatement()
}