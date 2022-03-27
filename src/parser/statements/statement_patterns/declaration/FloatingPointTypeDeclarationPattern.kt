package parser.statements.statement_patterns.declaration

import parser.nodes.evaluated.EvaluatedNodeType
import parser.nodes.evaluated.EvaluatedNodeTypeWrapper
import parser.structure.InterchangeableTokens
import tokens.patterns.Keyword

object FloatingPointTypeDeclarationPattern : DeclarationPattern(
    InterchangeableTokens(Keyword.FLOAT_KEYWORD, Keyword.DOUBLE_KEYWORD), EvaluatedNodeTypeWrapper(
        EvaluatedNodeType.DoubleType
    )
)