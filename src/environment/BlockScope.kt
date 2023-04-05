package environment

import environment.type.VariableInstance
import kotlin.collections.ArrayList

class BlockScope {
    private val heldValues: ArrayList<VariableInstance> = ArrayList()

    fun insertValue(instance: VariableInstance) {
        heldValues.add(instance)
    }
}