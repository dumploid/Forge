package tokens.structure

import tokens.Token

class TokenGrouping(vararg heldTokens: AbstractTokenHolder) : TokenStructure(*heldTokens) {

    fun tokenHolderEquals(checkedValue: TokenGrouping): Boolean {
        for(x in heldTokens.indices) {
            if(heldTokens[x] is Token) {
                if(heldTokens[x] != checkedValue.heldTokens[x]) return false
            }

            if(heldTokens[x] is TokenStructure) {
                return tokenHolderEquals(checkedValue.heldTokens[x])
            }

            throw RuntimeException("Unable to check for type " + heldTokens[x].javaClass.kotlin.qualifiedName)
        }

        return true
    }

    override fun tokenHolderEquals(checkedValue: AbstractTokenHolder): Boolean {
        return false
    }
}
