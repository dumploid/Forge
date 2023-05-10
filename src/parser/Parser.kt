package parser

import parser.nodes.ASTNode
import parser.nodes.ASTNodeValue
import parser.statements.Statement
import parser.statements.StatementFactory
import tokens.patterns.TokenPattern
import tokens.patterns.non_specific.ColonTokenPattern
import tokens.patterns.non_specific.StatementEndTokenPattern
import tokens.patterns.operators.UnfixedOperatorPattern

object Parser {
    fun parseStatements(inputTokens: List<ASTNode>): List<Statement> = getUnparsedStatements(inputTokens).map { x ->
        StatementFactory.createStatement(x)
    }

    private fun isBracket(currentNode: TokenPattern): Boolean =
        currentNode == UnfixedOperatorPattern.CLOSING_BRACE || currentNode == UnfixedOperatorPattern.OPENING_BRACE

    private fun getUnparsedStatements(inputNodes: List<ASTNode>): List<List<ASTNode>> {
        val output: MutableList<List<ASTNode>> = ArrayList()

        var currentNodeValueList = mutableListOf<ASTNode>()

        for (currentNode: ASTNode in inputNodes) {
            if (currentNode.heldValue !is ASTNodeValue.EvaluatedValue) {
                currentNodeValueList.add(currentNode)
            } else {
                val type = currentNode.heldValue.evaluatedValue.type
                if (type == StatementEndTokenPattern ||
                    type == ColonTokenPattern ||
                    isBracket(type)
                ) {
                    if (type != StatementEndTokenPattern) {
                        currentNodeValueList.add(currentNode)
                    }

                    output.add(currentNodeValueList)
                    currentNodeValueList = mutableListOf()
                    continue
                }

                currentNodeValueList.add(currentNode)
            }
        }

        return output
    }
}