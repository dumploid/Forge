package tokens.patterns.values.immutable_values.primitive_values

import tokens.patterns.values.AbstractValueTokenPattern

object BooleanTokenPattern : AbstractValueTokenPattern<Boolean>() {
    override val matchedPattern = Regex("true|false")
}