package parser.statements.statement_patterns.declaration

import parser.nodes.evaluated.EvaluatedNodeType
import parser.nodes.evaluated.EvaluatedNodeTypeWrapper
import tokens.patterns.Keyword

object StringTypeDeclarationPattern :
    DeclarationPattern(Keyword.STRING_KEYWORD, EvaluatedNodeTypeWrapper(EvaluatedNodeType.StringType))