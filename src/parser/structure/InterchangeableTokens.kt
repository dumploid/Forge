package parser.structure

class InterchangeableTokens(vararg passedTokens: AbstractTokenHolder) : TokenStructure(*passedTokens) {
    override fun tokenHolderEquals(checkedValue: AbstractTokenHolder): Boolean = heldTokens.any {
        if (it is TokenStructure) it.tokenHolderEquals(checkedValue) else checkedValue == it
    }
}