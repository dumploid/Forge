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

    override fun getMatchingValue(comparedValue: List<ASTNode>): ASTNodePattern {
        for (nodeIndex in 0..comparedValue.size) {
            for (checkedDelimiter in nodePatterns) {
                val delimiterSize = checkedDelimiter.matchedNodePattern.size
                if (nodeIndex > comparedValue.size - delimiterSize) continue
                if (checkedDelimiter.matches(comparedValue.subList(nodeIndex, nodeIndex + delimiterSize))) {
                    return checkedDelimiter
                }
            }
        }

        throw IllegalStateException("Required a match from nodePatterns")
    }
}