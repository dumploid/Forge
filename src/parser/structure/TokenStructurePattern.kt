package parser.structure

import utils.patterns.Pattern

abstract class TokenStructurePattern(vararg val heldTokenPatterns: Pattern<*>) :
    Pattern<Pattern<*>>