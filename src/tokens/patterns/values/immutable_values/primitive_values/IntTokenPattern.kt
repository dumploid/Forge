package tokens.patterns.values.immutable_values.primitive_values

import tokens.patterns.values.AbstractValueTokenPattern

object IntTokenPattern : AbstractValueTokenPattern<Int>() {
    override val matchedPattern = Regex("(0b[10_]+)|(0o[0-8_]+)|(0x[0-9A-Fa-f_]+)|((\\d|_)+)")
    override fun evaluate(from: String): Int {
        val radix = when {
            from.startsWith("0b") -> 2
            from.startsWith("0o") -> 8
            from.startsWith("0x") -> 16
            else -> 10
        }

        return if (radix != 10) {
            from.drop(2)
        } else {
            from
        }.toInt(radix)
    }
}