package tokens

import tokens.structure.AbstractTokenHolder

abstract class Token: AbstractTokenHolder() {
    abstract val matchedPattern: Regex
}