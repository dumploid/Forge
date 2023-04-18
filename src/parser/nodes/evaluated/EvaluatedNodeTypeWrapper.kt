package parser.nodes.evaluated

import parser.nodes.AbstractSyntaxTreeNodePattern
import utils.patterns.Pattern

class EvaluatedNodeTypeWrapper(val type: EvaluatedNodeType) :
    AbstractSyntaxTreeNodePattern<Pattern<*>> {
    override fun matches(checkedValue: Pattern<*>): Boolean = type.typeMatches(checkedValue)
}