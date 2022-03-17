package parser.statements.statement_patterns

import parser.structure.TokenGrouping
import tokens.keywords.built_in_types.StringKeyword
import tokens.non_specific.ValidName
import tokens.operators.AssignmentOperator
import tokens.values.immutable_values.StringToken

object StringTypeDeclaration : StatementPattern(
    TokenGrouping(StringKeyword,
        ValidName,
        AssignmentOperator,
        StringToken
    ))