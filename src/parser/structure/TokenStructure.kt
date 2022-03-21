package parser.structure

abstract class TokenStructure(vararg val heldTokens : AbstractTokenHolder<*>) : AbstractTokenHolder<AbstractTokenHolder<*>>()