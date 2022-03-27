package parser.structure

class InterchangeableTokens(vararg heldTokenPatterns: AbstractTokenHolderPattern<*>) :
    TokenStructurePattern(*heldTokenPatterns) {
    override fun matches(checkedValue: AbstractTokenHolderPattern<*>): Boolean = heldTokenPatterns.any {
        when (it) {
            is TokenStructurePattern -> it.matches(checkedValue)

            else -> {
                checkedValue == it
            }
        }
    }
}