package tokens.patterns.non_specific

import tokens.patterns.TokenPattern

object StatementEndTokenPattern : TokenPattern() {
    override val matchedPattern = Regex(";")
}