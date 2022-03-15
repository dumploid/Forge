package statements

import tokens.Token

object StatementMatcher {
    fun matches(vararg values : Token) : Regex {
        var patternValue = "^"

        values.forEach {
            patternValue += it.matchedPattern.toString() + " *"
        }

        return Regex(patternValue + "\$")
    }
}