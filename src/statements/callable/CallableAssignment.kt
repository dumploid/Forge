package statements.callable

import value.Value

class CallableAssignment<T>(val variableName: String, val setValue: Value<T>): CallableStatement() {
    override fun run() {
        TODO("Not yet implemented")
    }
}