package value.expression

import value.Value

abstract class Expression<T>(inputString: String) : Value<T>() {
    abstract fun getValue(): T
}