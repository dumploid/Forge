package parser.statements.statement_patterns.declaration

import parser.nodes.evaluated.EvaluatedNodeType
import parser.nodes.evaluated.EvaluatedNodeTypeWrapper
import parser.structure.InterchangeableTokens
import tokens.patterns.Keyword

object IntTypeDeclarationPattern : DeclarationPattern(
    InterchangeableTokens(Keyword.INT_KEYWORD, Keyword.LONG_KEYWORD, Keyword.SHORT_KEYWORD, Keyword.BYTE_KEYWORD),
    EvaluatedNodeTypeWrapper(EvaluatedNodeType.IntegerType)
)