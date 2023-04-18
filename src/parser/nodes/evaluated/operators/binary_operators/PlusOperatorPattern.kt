package parser.nodes.evaluated.operators.binary_operators

import parser.nodes.evaluated.EvaluatedNodeType
import parser.nodes.evaluated.EvaluatedNodeTypeWrapper
import tokens.patterns.operators.binary_operators.MathOperatorPattern
import utils.patterns.Pattern

object StringAdditionPattern : PlusOperatorPattern(EvaluatedNodeTypeWrapper(EvaluatedNodeType.StringType)) {
    override fun getNodeType(): EvaluatedNodeType = EvaluatedNodeType.StringType
}

abstract class PlusOperatorPattern(left: Pattern<*>, right: Pattern<*>) :
    BinaryOperatorPattern(left, MathOperatorPattern.PLUS_OPERATOR, right) {
    constructor(mirrorType: Pattern<*>) : this(mirrorType, mirrorType)
}