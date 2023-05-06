package tokens.patterns.values.immutable_values.primitive_values

import tokens.patterns.TokenPattern

object BooleanTokenPattern : TokenPattern {
    override val matchedPattern = Regex("true|false")
}