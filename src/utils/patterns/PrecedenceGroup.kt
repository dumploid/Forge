package utils.patterns

interface PrecedenceGroup<T, P : Pattern<T>> {
    fun containsMatchingValue(comparedValue: T): Boolean

    fun getMatchingValue(comparedValue: T): P
}