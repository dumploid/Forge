package tokens.patterns.values.immutable_values.primitive_values

import tokens.patterns.TokenPattern

object CharacterTokenPattern : TokenPattern {
    override val matchedPattern = Regex("'(([^\\\\'])|(\\\\[ntrv\\\\'\"?]))'")
}