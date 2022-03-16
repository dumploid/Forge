package tokens.structure

abstract class TokenStructure(vararg val heldTokens : AbstractTokenHolder): AbstractTokenHolder() {
    abstract fun tokenHolderEquals(checkedValue: AbstractTokenHolder) : Boolean
}