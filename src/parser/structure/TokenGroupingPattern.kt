package parser.structure

import parser.nodes.evaluated.EvaluatedNodeTypeWrapper
import tokens.patterns.TokenPattern
import utils.patterns.Pattern

class TokenGroupingPattern(vararg heldTokenPatterns: Pattern<*>) :
    TokenStructurePattern(*heldTokenPatterns) {

    constructor(tokenList: List<Pattern<*>>) : this(*tokenList.toTypedArray())

    override fun matches(checkedValue: Pattern<*>): Boolean {
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
