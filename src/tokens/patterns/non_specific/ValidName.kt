package tokens.patterns.non_specific

import tokens.patterns.TokenPattern

object ValidName : TokenPattern() {
    override val matchedPattern = Regex("[a-zA-Z\$_][a-zA-Z0-9\$_]*")
}