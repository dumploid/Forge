package parser.statements.statement_patterns

import tokens.patterns.keywords.*
import tokens.patterns.non_specific.ValidName
import tokens.patterns.operators.AssignmentOperator
import parser.structure.*
import tokens.patterns.values.immutable_values.primitive_values.IntTokenPattern

object IntTypeDeclarationPattern : StatementPattern() {
    override val tokenPattern: TokenStructure = TokenGrouping(
        InterchangeableTokens(IntKeyword, LongKeyword, ShortKeyword, ByteKeyword),
        ValidName,
        AssignmentOperator,
        IntTokenPattern
    )
}