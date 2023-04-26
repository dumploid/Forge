package environment

import java.util.LinkedList

class VariableSpace {
    val blocks: LinkedList<BlockScope> = LinkedList()

    init {
        blocks.add(BlockScope()) //outer most scope
    }

    fun currentBlock(): BlockScope {
        return blocks.last()
    }
}