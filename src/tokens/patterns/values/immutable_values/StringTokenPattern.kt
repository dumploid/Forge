package tokens.patterns.values.immutable_values

import tokens.patterns.TokenPattern

object StringTokenPattern : TokenPattern {
    override val matchedPattern = Regex("\".*?[^\\\\](\\\\\\\\)*\"")
}