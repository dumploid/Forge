package tokens.non_specific

import tokens.Token

object StatementEndToken : Token(){
    override val matchedPattern = Regex(";")
}