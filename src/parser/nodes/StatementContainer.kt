package parser.nodes

import parser.statements.statement_patterns.StatementPattern

class StatementContainer(val heldStatements: List<StatementPattern>): AbstractSyntaxTreeNode()