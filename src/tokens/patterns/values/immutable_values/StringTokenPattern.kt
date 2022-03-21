package tokens.patterns.values.immutable_values

import tokens.patterns.values.AbstractValueTokenPattern

object StringTokenPattern : AbstractValueTokenPattern<Int>() {
    override val matchedPattern = Regex("\".*?[^\\\\](\\\\\\\\)*\"")
}