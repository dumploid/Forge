package environment

import environment.type.VariableInstance

class BlockScope {
    val heldValues: HashMap<String, VariableInstance<*>> = HashMap()

    fun insertValue(instance: VariableInstance<*>, instanceName: String) {
        heldValues[instanceName] = instance
    }
}