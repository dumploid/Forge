package tokens.token_patterns

import tokens.Token

class InterchangeableToken(tokenA: Token, tokenB: Token): Token() {
    override val matchedPattern = Regex("(" + tokenA.matchedPattern.toString() + "|" + tokenB.matchedPattern.toString() + ")")
}