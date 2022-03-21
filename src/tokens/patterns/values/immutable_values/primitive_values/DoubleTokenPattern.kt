package tokens.patterns.values.immutable_values.primitive_values

import tokens.patterns.values.AbstractValueTokenPattern

object DoubleTokenPattern : AbstractValueTokenPattern<Double>() {
    override val matchedPattern = Regex("[+-]?[0-9]?\\.[0-9]+")
}