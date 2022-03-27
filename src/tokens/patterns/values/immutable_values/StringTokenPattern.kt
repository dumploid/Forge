package tokens.patterns.values.immutable_values

import tokens.patterns.values.AbstractValueTokenPattern

object StringTokenPattern : AbstractValueTokenPattern<String>() {
    override val matchedPattern = Regex("\".*?[^\\\\](\\\\\\\\)*\"")
}