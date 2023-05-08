package tokens.patterns.values.immutable_values.primitive_values

import tokens.patterns.TokenPattern

object DoubleTokenPattern : TokenPattern {
    override val matchedPattern = Regex("[+-]?[0-9]*\\.[0-9]+")
}