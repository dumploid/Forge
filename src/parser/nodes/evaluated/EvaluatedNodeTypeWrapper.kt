package parser.nodes.evaluated

import parser.nodes.AbstractSyntaxTreeNodePattern
import parser.structure.AbstractTokenHolderPattern

class EvaluatedNodeTypeWrapper(val type: EvaluatedNodeType) :
    AbstractSyntaxTreeNodePattern<AbstractTokenHolderPattern<*>> {
    override fun matches(checkedValue: AbstractTokenHolderPattern<*>): Boolean = type.typeMatches(checkedValue)
}