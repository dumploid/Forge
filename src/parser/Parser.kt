package parser

import parser.nodes.ASTNode
import parser.statements.Statement
import parser.statements.StatementFactory
import tokens.patterns.non_specific.ColonTokenPattern
import tokens.patterns.non_specific.StatementEndTokenPattern
import tokens.patterns.operators.UnfixedOperatorPattern

object Parser {
    fun parseStatements(inputTokens: List<ASTNode>): List<Statement> = getUnparsedStatements(inputTokens).map { x ->
        StatementFactory.createStatement(x)
    }

    private fun isBracket(currentNode: ASTNode): Boolean =
        currentNode.heldValue.type == UnfixedOperatorPattern.CLOSING_BRACE || currentNode.heldValue.type == UnfixedOperatorPattern.OPENING_BRACE

    private fun getUnparsedStatements(inputNodes: List<ASTNode>): List<List<ASTNode>> {
        val output: MutableList<List<ASTNode>> = ArrayList()

        var currentNodeValueList = mutableListOf<ASTNode>()

        for (currentNode: ASTNode in inputNodes) {
            if (currentNode.heldValue.type == StatementEndTokenPattern ||
                currentNode.heldValue.type == ColonTokenPattern ||
                isBracket(currentNode)
            ) {
                if (currentNode.heldValue.type != StatementEndTokenPattern) {
                    currentNodeValueList.add(currentNode)
                }

                output.add(currentNodeValueList)
                currentNodeValueList = mutableListOf()
                continue
            }

            currentNodeValueList.add(currentNode)
        }

        return output
    }
}