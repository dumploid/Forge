package tokens.patterns

import utils.patterns.Pattern

interface TokenPattern : Pattern<String> {
    val matchedPattern: Regex

    override fun matches(checkedValue: String): Boolean = matchedPattern.matches(checkedValue)
}