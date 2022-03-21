package value.immutables

class IntType(override val heldValue: Int) : ImmutableType<Int>() {
    constructor(setValue: String) : this(setValue.toInt())
}