package environment

import environment.type.VariableInstance

class VariableSpace {
    val heldValues: HashMap<String, VariableInstance> = HashMap()

    fun getVariable(variableName: String): VariableInstance {
        if (heldValues.containsKey(variableName)) {
            return heldValues[variableName]!!
        }

        throw RuntimeException("Unable to retrieve variable of name $variableName")
    }

    fun insertValue(instance: VariableInstance, instanceName: String) {
        heldValues[instanceName] = instance
    }
}