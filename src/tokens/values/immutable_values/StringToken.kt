package tokens.values.immutable_values

import tokens.values.AbstractValueToken

object StringToken : AbstractValueToken<Int>() {
    override val matchedPattern =  Regex("\\\".*?[^\\\\](\\\\\\\\)*\\\"")
}