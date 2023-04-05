package environment

import java.util.LinkedList

object VariableSpace {
    private val blocks: LinkedList<BlockScope> = LinkedList()

    init {
        blocks.push(BlockScope()) //outer most scope
    }

    fun currentBlock(): BlockScope {
        return blocks.last()
    }
}