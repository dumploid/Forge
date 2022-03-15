package tokens.non_specific

import tokens.Token

object IgnoredToken: Token() {
    override val matchedPattern = Regex(" ")
}