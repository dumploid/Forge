package parser.nodes

import tokens.TokenValue

sealed class ASTNodeValue {
    class EvaluatedValue(val evaluatedValue: TokenValue): ASTNodeValue()

    class IntegerValue(val integerValue: Int): ASTNodeValue()
    class DoubleValue(val doubleValue: Double): ASTNodeValue()
    class StringValue(val stringValue: String): ASTNodeValue()
    class CharValue(val charValue: Char): ASTNodeValue()
    class BooleanValue(val booleanValue: Boolean): ASTNodeValue()
}