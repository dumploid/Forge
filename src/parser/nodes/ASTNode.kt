package parser.nodes

import interpreter
import exceptions.ForgeEvaluationException
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.UnaryOperators
import tokens.patterns.operators.binary_operators.*
import kotlin.reflect.KClass

class ASTNode(val heldValue: ASTNodeValue, val children: List<ASTNode>) {
    @Suppress("UNCHECKED_CAST")
    fun <T : Any> evaluate(): T {
        return when (heldValue) {
            is ASTNodeValue.StringValue -> heldValue.stringValue as T

            is ASTNodeValue.CharValue -> heldValue.charValue as T

            is ASTNodeValue.BooleanValue -> heldValue.booleanValue as T

            is ASTNodeValue.IntegerValue -> heldValue.integerValue as T

            is ASTNodeValue.DoubleValue -> heldValue.doubleValue as T

            is ASTNodeValue.EvaluatedValue -> when (heldValue.evaluatedValue.type) {
                ValidName -> interpreter.variableSpace.getVariable(heldValue.evaluatedValue.value).value as T

                MathOperatorPattern.PLUS_OPERATOR -> {
                    val left = children[0].evaluate<T>()
                    val right = children[1].evaluate<T>()

                    val nodeType = getNodeType()

                    when (nodeType) {
                        String::class -> left as String + right as String
                        Char::class -> left as Char + (right as Char).code
                        Int::class -> left as Int + right as Int
                        Double::class -> left as Double + right as Double
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} + ${nodeType.simpleName!!}"
                        )
                    } as T
                }

                MathOperatorPattern.MINUS_OPERATOR -> {
                    val left = children[0].evaluate<T>()
                    val right = children[1].evaluate<T>()

                    val nodeType = getNodeType()
                    when (nodeType) {
                        Int::class -> left as Int - right as Int
                        Double::class -> left as Double - right as Double
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} - ${nodeType.simpleName!!}"
                        )
                    } as T
                }

                MathOperatorPattern.MODULUS_OPERATOR -> {
                    val left = children[0].evaluate<T>()
                    val right = children[1].evaluate<T>()

                    val nodeType = getNodeType()
                    when (nodeType) {
                        Int::class -> left as Int % right as Int
                        Double::class -> left as Double % right as Double
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} % ${nodeType.simpleName!!}"
                        )
                    } as T
                }

                MathOperatorPattern.MULTIPLY_OPERATOR -> {
                    val left = children[0].evaluate<T>()
                    val right = children[1].evaluate<T>()

                    val nodeType = getNodeType()
                    when (nodeType) {
                        Int::class -> left as Int * right as Int
                        Double::class -> left as Double * right as Double
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} * ${nodeType.simpleName!!}"
                        )
                    } as T
                }

                MathOperatorPattern.DIVIDE_OPERATOR -> {
                    val left = children[0].evaluate<T>()
                    val right = children[1].evaluate<T>()

                    val nodeType = getNodeType()
                    when (nodeType) {
                        Int::class -> left as Int / right as Int
                        Double::class -> left as Double / right as Double
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} / ${nodeType.simpleName!!}"
                        )
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

                ComparisonOperatorPattern.LESS_THAN -> {
                    val left = children[0].evaluate<Any>()
                    val right = children[1].evaluate<Any>()

                    val nodeType = children[0].getNodeType()
                    when (nodeType) {
                        Int::class -> (left as Int) < (right as Int)
                        Double::class -> (left as Double) < (right as Double)
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} $heldValue ${nodeType.simpleName!!}"
                        )
                    } as T
                }
                ComparisonOperatorPattern.LESS_THAN_OR_EQUAL -> {
                    val left = children[0].evaluate<Any>()
                    val right = children[1].evaluate<Any>()

                    val nodeType = children[0].getNodeType()
                    when (nodeType) {
                        Int::class -> (left as Int) <= (right as Int)
                        Double::class -> (left as Double) <= (right as Double)
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} $heldValue ${nodeType.simpleName!!}"
                        )
                    } as T
                }
                ComparisonOperatorPattern.GREATER_THAN -> {
                    val left = children[0].evaluate<Any>()
                    val right = children[1].evaluate<Any>()

                    val nodeType = children[0].getNodeType()
                    when (nodeType) {
                        Int::class -> (left as Int) > (right as Int)
                        Double::class -> (left as Double) > (right as Double)
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} $heldValue ${nodeType.simpleName!!}"
                        )
                    } as T
                }
                ComparisonOperatorPattern.GREATER_THAN_OR_EQUAL -> {
                    val left = children[0].evaluate<Any>()
                    val right = children[1].evaluate<Any>()

                    val nodeType = children[0].getNodeType()
                    when (nodeType) {
                        Int::class -> (left as Int) >= (right as Int)
                        Double::class -> (left as Double) >= (right as Double)
                        else -> throw ForgeEvaluationException(
                            "$this",
                            "${nodeType.simpleName!!} $heldValue ${nodeType.simpleName!!}"
                        )
                    } as T
                }

                else -> throw ForgeEvaluationException("$this", "$heldValue")
            }
        }
    }

    private fun getNodeType(): KClass<out Any> = when (heldValue) {
        is ASTNodeValue.StringValue -> String::class
        is ASTNodeValue.CharValue -> Char::class
        is ASTNodeValue.BooleanValue -> Boolean::class
        is ASTNodeValue.IntegerValue -> Int::class
        is ASTNodeValue.DoubleValue -> Double::class

        is ASTNodeValue.EvaluatedValue -> when (heldValue.evaluatedValue.type) {
            ValidName -> interpreter.variableSpace.getVariable(heldValue.evaluatedValue.value).value::class

            MathOperatorPattern.PLUS_OPERATOR,
            MathOperatorPattern.MINUS_OPERATOR,
            MathOperatorPattern.MULTIPLY_OPERATOR,
            MathOperatorPattern.DIVIDE_OPERATOR,
            MathOperatorPattern.MODULUS_OPERATOR -> children[0].getNodeType()

            ComparisonOperatorPattern.LESS_THAN,
            ComparisonOperatorPattern.LESS_THAN_OR_EQUAL,
            ComparisonOperatorPattern.GREATER_THAN,
            ComparisonOperatorPattern.GREATER_THAN_OR_EQUAL -> Boolean::class

            else -> throw RuntimeException("Unable to evaluate ${heldValue.evaluatedValue}")
        }
    }
}