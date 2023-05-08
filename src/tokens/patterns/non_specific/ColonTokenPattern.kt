package tokens.patterns.non_specific

import tokens.patterns.TokenPattern

object ColonTokenPattern : TokenPattern {
    override val matchedPattern = Regex(":")
}