package parser.nodes

class TreeBuilder(val nodes: MutableList<ASTNode>) {
    private fun getContainingGroup(): NodePrecedenceGroup = evaluatedNodeList.find {
        it.containsMatchingValue(nodes)
    }!!

    fun buildTrees(): List<ASTNode> {
        if (!evaluatedNodeList.any { it.containsMatchingValue(nodes) }) return nodes

        val delimiter = getContainingGroup().getMatchingValue(nodes)
        val delimiterSize = delimiter.matchedNodePattern.size

        var currentIndex = 0
        while(currentIndex <= nodes.size - delimiterSize) {
            val window = nodes.subList(currentIndex, currentIndex + delimiterSize).toMutableList()
            if (delimiter.matches(window)) {
                val replacedNodeIndex = delimiter.matchedNodePattern.indexOfFirst { it is NodeType.RootSpecific }

                val replacedNode = window[replacedNodeIndex]
                val replacedNodeChildren = window.filter { x -> x != replacedNode }

                nodes.subList(currentIndex+1, currentIndex+delimiterSize).clear()
                nodes[currentIndex] = ASTNode(replacedNode.heldValue, replacedNodeChildren)
            } else {
                currentIndex++
            }
        }

        return TreeBuilder(nodes).buildTrees()
    }
}