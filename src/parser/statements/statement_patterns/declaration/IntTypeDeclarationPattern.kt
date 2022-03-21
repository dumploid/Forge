package parser.statements.statement_patterns.declaration

import tokens.patterns.keywords.*
import parser.structure.*
import tokens.patterns.values.immutable_values.primitive_values.IntTokenPattern

object IntTypeDeclarationPattern : DeclarationPattern(InterchangeableTokens(IntKeyword, LongKeyword, ShortKeyword, ByteKeyword), IntTokenPattern)