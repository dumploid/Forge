package parser.nodes

import utils.patterns.PrecedenceGroup

class NodePrecedenceGroup(private vararg val nodePatterns: ASTNodePattern) :
    PrecedenceGroup<List<ASTNode>, ASTNodePattern> {
    override fun containsMatchingValue(comparedValue: List<ASTNode>): Boolean =
        nodePatterns.any { currentASTNodePattern ->
            val windowSize = currentASTNodePattern.matchedNodePattern.size
            comparedValue.windowed(windowSize).any { y ->
                currentASTNodePattern.matches(y)
            }
        }


    override fun getMatchingValue(comparedValue: List<ASTNode>): ASTNodePattern =
        nodePatterns.find { currentASTNodePattern ->
            val windowSize = currentASTNodePattern.matchedNodePattern.size
            comparedValue.windowed(windowSize).any { y ->
                currentASTNodePattern.matches(y)
            }
        }!!
}