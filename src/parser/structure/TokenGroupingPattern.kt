package parser.structure

import parser.nodes.evaluated.EvaluatedNodeTypeWrapper
import tokens.patterns.TokenPattern

class TokenGroupingPattern(vararg heldTokenPatterns: AbstractTokenHolderPattern<*>) :
    TokenStructurePattern(*heldTokenPatterns) {

    constructor(tokenList: List<AbstractTokenHolderPattern<*>>) : this(*tokenList.toTypedArray())

    override fun matches(checkedValue: AbstractTokenHolderPattern<*>): Boolean {
        if (checkedValue !is TokenGroupingPattern) return false

        if (heldTokenPatterns.size != checkedValue.heldTokenPatterns.size) return false

        for (i in heldTokenPatterns.indices) {
            when (val currentTokenPattern = heldTokenPatterns[i]) {
                is TokenPattern -> if (currentTokenPattern != checkedValue.heldTokenPatterns[i]) return false

                is TokenStructurePattern -> if (!currentTokenPattern.matches(checkedValue.heldTokenPatterns[i])) return false

                is EvaluatedNodeTypeWrapper -> if (!currentTokenPattern.matches(checkedValue.heldTokenPatterns[i])) return false

                else -> throw RuntimeException("Unable to check for type " + heldTokenPatterns[i].javaClass.kotlin.qualifiedName)
            }
        }

        return true
    }
}
