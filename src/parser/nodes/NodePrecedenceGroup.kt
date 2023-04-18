package parser.nodes

import parser.nodes.evaluated.EvaluatedNodePattern
import parser.structure.TokenGroupingPattern
import utils.patterns.Pattern
import utils.patterns.PrecedenceGroup

class NodePrecedenceGroup(private vararg val tokenPatternGroup: EvaluatedNodePattern) :
    PrecedenceGroup<Pattern<*>, EvaluatedNodePattern> {

    fun containsMatchingNode(comparedTokenList: List<Pattern<*>>): Boolean {
        tokenPatternGroup.forEach {
            val currentPatternLength = it.getPatternLength()
            for (i in 0..(comparedTokenList.size - currentPatternLength)) {
                if (it.matches(
                        TokenGroupingPattern(comparedTokenList.subList(i, i + currentPatternLength))
                    )
                ) return true
            }
        }

        return false
    }

    override fun containsMatchingValue(comparedValue: Pattern<*>): Boolean =
        tokenPatternGroup.any { it.matches(comparedValue) }

    override fun getMatchingValue(comparedValue: Pattern<*>): EvaluatedNodePattern =
        tokenPatternGroup.find { it.matches(comparedValue) }!!

}