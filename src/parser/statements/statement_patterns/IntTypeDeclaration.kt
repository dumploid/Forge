package parser.statements.statement_patterns

import tokens.keywords.built_in_types.*
import tokens.non_specific.ValidName
import tokens.operators.AssignmentOperator
import parser.structure.*
import tokens.values.immutable_values.primitive_values.IntToken

object IntTypeDeclaration : StatementPattern(
    TokenGrouping(InterchangeableTokens(IntKeyword, LongKeyword, ShortKeyword, ByteKeyword),
        ValidName,
        AssignmentOperator,
        IntToken
    ))