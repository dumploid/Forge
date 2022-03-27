package tokens.patterns.values.immutable_values.primitive_values

import tokens.patterns.values.AbstractValueTokenPattern

object CharacterTokenPattern : AbstractValueTokenPattern<Char>() {
    override val matchedPattern = Regex("'(([^\\\\'])|(\\\\[ntrv\\\\'\"?]))'")
}