package utils.patterns

abstract class ValueContainer<P : Pattern<V>, V>(heldPattern: P, heldValue: V) {
    init {
        if (!heldPattern.matches(heldValue)) throw RuntimeException("Cannot match $heldValue to $heldPattern")
    }
}