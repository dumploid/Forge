package parser.nodes

import parser.nodes.evaluated.EvaluatedNodePattern
import parser.structure.AbstractTokenHolderPattern
import parser.structure.TokenGroupingPattern
import utils.patterns.PrecedenceGroup

class NodePrecedenceGroup(private vararg val tokenPatternGroup: EvaluatedNodePattern) :
    PrecedenceGroup<AbstractTokenHolderPattern<*>, EvaluatedNodePattern> {

    fun containsMatchingNode(comparedTokenList: List<AbstractTokenHolderPattern<*>>): Boolean {
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

    override fun containsMatchingValue(comparedValue: AbstractTokenHolderPattern<*>): Boolean =
        tokenPatternGroup.any { it.matches(comparedValue) }

    override fun getMatchingValue(comparedValue: AbstractTokenHolderPattern<*>): EvaluatedNodePattern =
        tokenPatternGroup.find { it.matches(comparedValue) }!!

}