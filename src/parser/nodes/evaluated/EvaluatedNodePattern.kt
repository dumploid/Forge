package parser.nodes.evaluated
import utils.patterns.Pattern

interface EvaluatedNodePattern : Pattern<Pattern<*>> {
    fun getNodeType(): EvaluatedNodeType

    fun getPatternLength(): Int
}