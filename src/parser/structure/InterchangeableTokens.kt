package parser.structure

class InterchangeableTokens(vararg heldTokens: AbstractTokenHolder<*>) : TokenStructure(*heldTokens) {
    override fun matches(checkedValue: AbstractTokenHolder<*>): Boolean = heldTokens.any {
        return when (it) {
            is TokenStructure -> it.matches(checkedValue)
            else -> checkedValue == it
        }
    }
}