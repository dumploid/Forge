package parser.nodes.evaluated.operators

import parser.nodes.evaluated.EvaluatedNodePattern
import tokens.patterns.operators.OperatorTokenPattern

abstract class OperatorNodePattern(val operatorToken: OperatorTokenPattern) : EvaluatedNodePattern