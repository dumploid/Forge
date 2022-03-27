package parser.nodes.evaluated

import parser.nodes.AbstractSyntaxTreeNodePattern
import parser.structure.AbstractTokenHolderPattern

interface EvaluatedNodePattern : AbstractSyntaxTreeNodePattern<AbstractTokenHolderPattern<*>> {
    fun getNodeType(): EvaluatedNodeType

    fun getPatternLength(): Int
}