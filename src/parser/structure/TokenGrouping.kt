package parser.structure

import tokens.patterns.TokenPattern

class TokenGrouping(vararg heldTokens: AbstractTokenHolder<*>) : TokenStructure(*heldTokens) {

    override fun matches(checkedValue: AbstractTokenHolder<*>): Boolean {
        if (checkedValue is TokenGrouping) {

            if (heldTokens.size != checkedValue.heldTokens.size) return false

            for (i in heldTokens.indices) {
                when {
                    (heldTokens[i] is TokenPattern) -> if (heldTokens[i] != checkedValue.heldTokens[i]) return false
                    (heldTokens[i] is TokenStructure) -> if (!(heldTokens[i] as TokenStructure).matches(
                            checkedValue.heldTokens[i]
                        )
                    ) return false

                    else -> throw RuntimeException("Unable to check for type " + heldTokens[i].javaClass.kotlin.qualifiedName)
                }
            }

            return true

        }
        return false
    }
}
