package tokens

import parser.structure.AbstractTokenHolder

abstract class Token: AbstractTokenHolder() {
    abstract val matchedPattern: Regex
}