package tokens.patterns.values.immutable_values.primitive_values

import tokens.patterns.TokenPattern

object IntTokenPattern : TokenPattern {
    override val matchedPattern = Regex("(0b[10_]+)|(0o[0-8_]+)|(0x[0-9A-Fa-f_]+)|((\\d|_)+)")
}