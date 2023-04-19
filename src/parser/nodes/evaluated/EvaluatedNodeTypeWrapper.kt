package parser.nodes.evaluated
import utils.patterns.Pattern

class EvaluatedNodeTypeWrapper(val type: EvaluatedNodeType) :
    Pattern<Pattern<*>> {
    override fun matches(checkedValue: Pattern<*>): Boolean = type.typeMatches(checkedValue)
}