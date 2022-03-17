package parser.structure

import tokens.Token

class TokenGrouping(vararg heldTokens: AbstractTokenHolder) : TokenStructure(*heldTokens) {

    init {
        println("declared!")
        println(heldTokens)
    }

    fun tokenHolderEquals(checkedValue: TokenGrouping): Boolean {
        if(heldTokens.size != checkedValue.heldTokens.size) return false

        for(i in heldTokens.indices) {
            when {
                (heldTokens[i] is Token) -> if(heldTokens[i] != checkedValue.heldTokens[i]) return false
                (heldTokens[i] is TokenStructure) -> if (! (heldTokens[i] as TokenStructure).tokenHolderEquals(checkedValue.heldTokens[i])) return false
                //doesn't match InterchangeableTokens for some reason??? ^
                (heldTokens[i] is InterchangeableTokens) -> if (! (heldTokens[i] as TokenStructure).tokenHolderEquals(checkedValue.heldTokens[i])) return true
                else -> throw RuntimeException("Unable to check for type " + heldTokens[i].javaClass.kotlin.qualifiedName)
            }
        }

        println("returned true")

        return true
    }

    override fun tokenHolderEquals(checkedValue: AbstractTokenHolder): Boolean {
        if(checkedValue is TokenGrouping) return tokenHolderEquals(checkedValue)
        return false
    }
}
