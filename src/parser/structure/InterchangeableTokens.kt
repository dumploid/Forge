package parser.structure

import utils.patterns.Pattern

class InterchangeableTokens(vararg heldTokenPatterns: Pattern<*>) :
    TokenStructurePattern(*heldTokenPatterns) {
    override fun matches(checkedValue: Pattern<*>): Boolean = heldTokenPatterns.any {
        when (it) {
            is TokenStructurePattern -> it.matches(checkedValue)

            else -> {
                checkedValue == it
            }
        }
    }
}