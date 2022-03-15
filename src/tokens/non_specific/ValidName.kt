package tokens.non_specific

import tokens.Token

object ValidName: Token() {
    override val matchedPattern =  Regex("[a-zA-Z\$_][a-zA-Z0-9\$_]*")

}