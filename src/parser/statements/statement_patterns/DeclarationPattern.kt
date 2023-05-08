package parser.statements.statement_patterns.declaration

import parser.nodes.ASTNodePattern
import parser.nodes.NodeType
import parser.statements.statement_patterns.StatementPattern
import tokens.patterns.Keyword
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.UnfixedOperatorPattern

abstract class DeclarationPattern(
    typeName: Keyword,
) : StatementPattern(
    ASTNodePattern(
        listOf(
            NodeType.Specific(typeName),
            NodeType.Specific(ValidName),
            NodeType.RootSpecific(UnfixedOperatorPattern.ASSIGNMENT_OPERATOR),
            NodeType.NonSpecific
        )
    )
)

object IntTypeDeclarationPattern : DeclarationPattern(Keyword.INT_KEYWORD)
object DoubleTypeDeclarationPattern : DeclarationPattern(Keyword.DOUBLE_KEYWORD)
object BooleanTypeDeclarationPattern : DeclarationPattern(Keyword.BOOLEAN_KEYWORD)
object CharTypeDeclarationPattern : DeclarationPattern(Keyword.CHAR_KEYWORD)
object StringTypeDeclarationPattern : DeclarationPattern(Keyword.STRING_KEYWORD)