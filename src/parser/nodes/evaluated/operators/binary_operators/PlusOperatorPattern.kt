package parser.nodes.evaluated.operators.binary_operators

import parser.nodes.evaluated.EvaluatedNodeType
import parser.nodes.evaluated.EvaluatedNodeTypeWrapper
import parser.structure.AbstractTokenHolderPattern
import tokens.patterns.operators.binary_operators.MathOperatorPattern

object StringAdditionPattern : PlusOperatorPattern(EvaluatedNodeTypeWrapper(EvaluatedNodeType.StringType)) {
    override fun getNodeType(): EvaluatedNodeType = EvaluatedNodeType.StringType
}

abstract class PlusOperatorPattern(left: AbstractTokenHolderPattern<*>, right: AbstractTokenHolderPattern<*>) :
    BinaryOperatorPattern(left, MathOperatorPattern.PLUS_OPERATOR, right) {
    constructor(mirrorType: AbstractTokenHolderPattern<*>) : this(mirrorType, mirrorType)
}