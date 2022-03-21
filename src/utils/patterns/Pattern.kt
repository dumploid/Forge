package utils.patterns

interface Pattern<T> {
    fun matches(checkedValue: T): Boolean
}