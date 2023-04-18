package parser.nodes.evaluated

import parser.nodes.AbstractSyntaxTreeNodePattern
import utils.patterns.Pattern

interface EvaluatedNodePattern : AbstractSyntaxTreeNodePattern<Pattern<*>> {
    fun getNodeType(): EvaluatedNodeType

    fun getPatternLength(): Int
}