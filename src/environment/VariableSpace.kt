package environment

import environment.type.VariableInstance
import java.lang.NullPointerException

class VariableSpace {
    val heldValues: HashMap<String, VariableInstance> = HashMap()

    fun getVariable(variableName: String): VariableInstance {
        try {
            return heldValues[variableName]!!
        } catch (e: NullPointerException) {
            throw RuntimeException("Unable to retrieve variable of name $variableName")
        }
    }

    fun insertValue(instance: VariableInstance, instanceName: String) {
        heldValues[instanceName] = instance
    }
}