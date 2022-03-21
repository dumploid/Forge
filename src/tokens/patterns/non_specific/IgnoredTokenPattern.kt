package tokens.patterns.non_specific

import tokens.patterns.TokenPattern

object IgnoredTokenPattern : TokenPattern() {
    override val matchedPattern = Regex(" ")
}