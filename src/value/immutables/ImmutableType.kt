package value.immutables

import value.Value

abstract class ImmutableType<T> : Value<T>() {
    abstract override val heldValue: T

    fun getValue(): T {
        return heldValue
    }
}