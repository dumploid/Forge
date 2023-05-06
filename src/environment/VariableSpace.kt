package environment

import environment.type.VariableInstance
import java.util.LinkedList

class VariableSpace {
    val blocks: LinkedList<BlockScope> = LinkedList()

    init {
        blocks.add(BlockScope()) //outer most scope
    }

    fun currentBlock(): BlockScope {
        return blocks.last()
    }

    fun getVariable(variableName: String): VariableInstance<*> {
        for (block in blocks) {
            if (block.heldValues.containsKey(variableName)) {
                return block.heldValues[variableName]!!
            }
        }

        throw RuntimeException("Unable to retrieve variable of type name $variableName")
    }
}