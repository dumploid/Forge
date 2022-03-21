package tokens.patterns

import parser.structure.AbstractTokenHolder

abstract class TokenPattern : AbstractTokenHolder<String>() {
    abstract val matchedPattern: Regex

    override fun matches(checkedValue: String): Boolean = matchedPattern.matches(checkedValue)
}