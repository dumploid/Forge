package parser.nodes

import interpreter
import tokens.TokenValue
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.UnaryOperators
import tokens.patterns.operators.binary_operators.ComparisonOperatorPattern
import tokens.patterns.operators.binary_operators.LogicalOperatorPattern
import tokens.patterns.operators.binary_operators.MathOperatorPattern
import tokens.patterns.values.immutable_values.StringTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.*
import java.lang.IllegalStateException
import kotlin.experimental.inv
import kotlin.reflect.KClass

data class ASTNode(val heldValue: TokenValue, val children: List<ASTNode>) {

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> evaluate(clazz: KClass<T>): T = when (heldValue.type to clazz) {
        ValidName to clazz -> interpreter.variableSpace.getVariable(heldValue.value).value as T

        StringTokenPattern to String::class -> {
            val quotedString = heldValue.value
            quotedString.substring(1 until quotedString.length-1) as T
        }
        CharacterTokenPattern to Char::class -> heldValue.value[1] as T //Need to make this work for escape chars

        BooleanTokenPattern to Boolean::class -> (heldValue.value == "true") as T

        IntTokenPattern to Byte::class,
        IntTokenPattern to Short::class,
        IntTokenPattern to Int::class,
        IntTokenPattern to Long::class -> {
            val from = heldValue.value
            val radix = when {
                from.startsWith("0b") -> 2
                from.startsWith("0o") -> 8
                from.startsWith("0x") -> 16
                else -> 10
            }

            val parsedValue = if (radix != 10) {
                from.drop(2)
            } else {
                from
            }

            when (clazz) {
                Byte::class -> parsedValue.toByte(radix) as T
                Short::class -> parsedValue.toShort(radix) as T
                Int::class -> parsedValue.toInt(radix) as T
                Long::class -> parsedValue.toLong(radix) as T
                else -> throw IllegalStateException("Must be of type byte, short, int or long")
            }
        }

        DoubleTokenPattern to Double::class -> heldValue.value.toDouble() as T
        DoubleTokenPattern to Float::class -> heldValue.value.toFloat() as T

        (MathOperatorPattern.PLUS_OPERATOR to clazz) -> {
            val left = children[0].evaluate(clazz)
            val right = children[1].evaluate(clazz)
            when (clazz) {
                String::class -> left as String + right as Number
                Char::class -> left as Char + (right as Char).code
                Byte::class -> left as Byte + right as Byte
                Short::class -> left as Short + right as Short
                Int::class -> left as Int + right as Int
                Long::class -> left as Long + right as Long
                Double::class -> left as Double + right as Double
                Float::class -> left as Float + right as Float
                else -> throw RuntimeException("Unable to evaluate $this")
            } as T
        }

        (MathOperatorPattern.MINUS_OPERATOR to clazz) -> {
            val left = children[0].evaluate(clazz)
            val right = children[1].evaluate(clazz)
            when (clazz) {
                Byte::class -> left as Byte - right as Byte
                Short::class -> left as Short - right as Short
                Int::class -> left as Int - right as Int
                Long::class -> left as Long - right as Long
                Double::class -> left as Double - right as Double
                Float::class -> left as Float - right as Float
                else -> throw RuntimeException("Unable to evaluate $this")
            } as T
        }

        (MathOperatorPattern.MODULUS_OPERATOR to clazz) -> {
            val left = children[0].evaluate(clazz)
            val right = children[1].evaluate(clazz)
            when (clazz) {
                Byte::class -> left as Byte % right as Byte
                Short::class -> left as Short % right as Short
                Int::class -> left as Int % right as Int
                Long::class -> left as Long % right as Long
                Double::class -> left as Double % right as Double
                Float::class -> left as Float % right as Float
                else -> throw RuntimeException("Unable to evaluate $this")
            } as T
        }

        (MathOperatorPattern.MULTIPLY_OPERATOR to clazz) -> {
            val left = children[0].evaluate(clazz)
            val right = children[1].evaluate(clazz)
            when (clazz) {
                Byte::class -> left as Byte * right as Byte
                Short::class -> left as Short * right as Short
                Int::class -> left as Int * right as Int
                Long::class -> left as Long * right as Long
                Double::class -> left as Double * right as Double
                Float::class -> left as Float * right as Float
                else -> throw RuntimeException("Unable to evaluate $this")
            } as T
        }

        (MathOperatorPattern.DIVIDE_OPERATOR to clazz) -> {
            val left = children[0].evaluate(clazz)
            val right = children[1].evaluate(clazz)
            when (clazz) {
                Byte::class -> left as Byte / right as Byte
                Short::class -> left as Short / right as Short
                Int::class -> left as Int / right as Int
                Long::class -> left as Long / right as Long
                Double::class -> left as Double / right as Double
                Float::class -> left as Float / right as Float
                else -> throw RuntimeException("Unable to evaluate $this")
            } as T
        }

        (LogicalOperatorPattern.LOGICAL_OR to Boolean::class) -> {
            val left = children[0].evaluate(Boolean::class)
            val right = children[1].evaluate(Boolean::class)

            (left || right) as T
        }

        (LogicalOperatorPattern.LOGICAL_AND to Boolean::class) -> {
            val left = children[0].evaluate(Boolean::class)
            val right = children[1].evaluate(Boolean::class)

            (left && right) as T
        }

        (UnaryOperators.UNARY_NOT to Boolean::class) -> {
            val flipped = children[0].evaluate(Boolean::class)

            !flipped as T
        }

        (UnaryOperators.UNARY_BITWISE_NOT to Boolean::class) -> {
            val flipped = children[0].evaluate(clazz)

            when (clazz) {
                Byte::class -> (flipped as Byte).inv()
                Short::class -> (flipped as Short).inv()
                Int::class -> (flipped as Int).inv()
                Long::class -> (flipped as Long).inv()
                else -> throw RuntimeException("Unable to evaluate $this")
            } as T
        }

        //currently bugged :/
        (ComparisonOperatorPattern.EQUALS to clazz) -> {
            val left = children[0].evaluate(clazz)
            val right = children[1].evaluate(clazz)

            (left == right) as T
        }
        else -> throw RuntimeException("Unable to evaluate $this")
    }

}
