package parser.nodes

import interpreter
import exceptions.ForgeEvaluationException
import tokens.TokenValue
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.UnaryOperators
import tokens.patterns.operators.binary_operators.*
import tokens.patterns.values.immutable_values.StringTokenPattern
import tokens.patterns.values.immutable_values.primitive_values.*
import kotlin.reflect.KClass

data class ASTNode(val heldValue: TokenValue, val children: List<ASTNode>) {

    private fun getNodeType(): KClass<out Any> = when (heldValue.type) {
        ValidName -> interpreter.variableSpace.getVariable(heldValue.value).value::class

        StringTokenPattern -> String::class
        CharacterTokenPattern -> Char::class
        BooleanTokenPattern -> Boolean::class
        IntTokenPattern -> Int::class
        DoubleTokenPattern -> Double::class

        MathOperatorPattern.PLUS_OPERATOR,
        MathOperatorPattern.MINUS_OPERATOR,
        MathOperatorPattern.MULTIPLY_OPERATOR,
        MathOperatorPattern.DIVIDE_OPERATOR,
        MathOperatorPattern.MODULUS_OPERATOR -> children[0].getNodeType()

        ComparisonOperatorPattern.LESS_THAN,
        ComparisonOperatorPattern.LESS_THAN_OR_EQUAL,
        ComparisonOperatorPattern.GREATER_THAN,
        ComparisonOperatorPattern.GREATER_THAN_OR_EQUAL -> Boolean::class

        else -> throw RuntimeException("Unimplemented type: ${this.heldValue.type}")
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> evaluate(): T {
        return when (heldValue.type) {
            ValidName -> interpreter.variableSpace.getVariable(heldValue.value).value as T

            StringTokenPattern -> {
                val quotedString = heldValue.value
                quotedString.substring(1 until quotedString.length - 1) as T
            }

            CharacterTokenPattern -> heldValue.value[1] as T //Need to make this work for escape chars

            BooleanTokenPattern -> (heldValue.value == "true") as T

            IntTokenPattern -> {
                val from = heldValue.value
                val radix = when {
                    from.startsWith("0b") -> 2
                    from.startsWith("0o") -> 8
                    from.startsWith("0x") -> 16
                    else -> 10
                }

                if (radix != 10) {
                    from.drop(2)
                } else {
                    from
                }.toInt(radix) as T
            }

            DoubleTokenPattern -> {
                heldValue.value.toDouble() as T
            }

            MathOperatorPattern.PLUS_OPERATOR -> {
                val left = children[0].evaluate<T>()
                val right = children[1].evaluate<T>()

                val nodeType = getNodeType()

                when (nodeType) {
                    String::class -> left as String + right as String
                    Char::class -> left as Char + (right as Char).code
                    Int::class -> left as Int + right as Int
                    Double::class -> left as Double + right as Double
                    else -> throw ForgeEvaluationException("$this",  "${nodeType.simpleName!!} + ${nodeType.simpleName!!}")
                } as T
            }

            MathOperatorPattern.MINUS_OPERATOR -> {
                val left = children[0].evaluate<T>()
                val right = children[1].evaluate<T>()

                val nodeType = getNodeType()
                when (nodeType) {
                    Int::class -> left as Int - right as Int
                    Double::class -> left as Double - right as Double
                    else -> throw ForgeEvaluationException("$this",  "${nodeType.simpleName!!} - ${nodeType.simpleName!!}")
                } as T
            }

            MathOperatorPattern.MODULUS_OPERATOR -> {
                val left = children[0].evaluate<T>()
                val right = children[1].evaluate<T>()

                val nodeType = getNodeType()
                when (nodeType) {
                    Int::class -> left as Int % right as Int
                    Double::class -> left as Double % right as Double
                    else -> throw ForgeEvaluationException("$this",  "${nodeType.simpleName!!} % ${nodeType.simpleName!!}")
                } as T
            }

            MathOperatorPattern.MULTIPLY_OPERATOR -> {
                val left = children[0].evaluate<T>()
                val right = children[1].evaluate<T>()

                val nodeType = getNodeType()
                when (nodeType) {
                    Int::class -> left as Int * right as Int
                    Double::class -> left as Double * right as Double
                    else -> throw ForgeEvaluationException("$this",  "${nodeType.simpleName!!} * ${nodeType.simpleName!!}")
                } as T
            }

            MathOperatorPattern.DIVIDE_OPERATOR -> {
                val left = children[0].evaluate<T>()
                val right = children[1].evaluate<T>()

                val nodeType = getNodeType()
                when (nodeType) {
                    Int::class -> left as Int / right as Int
                    Double::class -> left as Double / right as Double
                    else -> throw ForgeEvaluationException("$this",  "${nodeType.simpleName!!} / ${nodeType.simpleName!!}")
                } as T
            }

            LogicalOperatorPattern.LOGICAL_OR -> {
                val left = children[0].evaluate<Boolean>()
                val right = children[1].evaluate<Boolean>()

                (left || right) as T
            }

            LogicalOperatorPattern.LOGICAL_AND -> {
                val left = children[0].evaluate<Boolean>()
                val right = children[1].evaluate<Boolean>()

                (left && right) as T
            }

            UnaryOperators.UNARY_NOT -> {
                val flipped = children[0].evaluate<Boolean>()

                !flipped as T
            }

            UnaryOperators.UNARY_BITWISE_NOT -> {
                val flipped = children[0].evaluate<Int>()
                flipped.inv() as T
            }

            ComparisonOperatorPattern.EQUALS -> {
                val left = children[0].evaluate<Any>()
                val right = children[1].evaluate<Any>()

                (left == right) as T
            }

            ComparisonOperatorPattern.LESS_THAN,
            ComparisonOperatorPattern.LESS_THAN_OR_EQUAL,
            ComparisonOperatorPattern.GREATER_THAN,
            ComparisonOperatorPattern.GREATER_THAN_OR_EQUAL -> {
                val left = children[0].evaluate<Any>()
                val right = children[1].evaluate<Any>()

                val nodeType = children[0].getNodeType()
                when (nodeType) {
                    Int::class -> (left as Int) < (right as Int)
                    Double::class -> (left as Double) < (right as Double)
                    else -> throw ForgeEvaluationException("$this",  "${nodeType.simpleName!!} ${heldValue.value} ${nodeType.simpleName!!}")
                } as T
            }

            else -> throw ForgeEvaluationException("$this",  "${heldValue.type}")
        }
    }
}