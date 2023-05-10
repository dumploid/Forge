package environment

import exceptions.ForgeException
import parser.nodes.ASTNodeValue
import parser.statements.Statement
import parser.statements.statement_impl.ClosingBraceStatement
import parser.statements.statement_impl.EndStatement
import parser.statements.statement_impl.IfStatement
import parser.statements.statement_impl.LabelStatement
import kotlin.system.exitProcess

class Interpreter(val statements: List<Statement>) {
    private var pointer = 0
    val variableSpace = VariableSpace()
    val stack = ArrayDeque<Any>()

    fun execute() {
        while (pointer < statements.size) {
            val statement = statements[pointer]
            pointer += 1

            try {
                statement.run()
            } catch (e: ForgeException) {
                println("Error running code:")
                println(e.message)
                println("at: ${statement.heldValue.map { it.heldValue }}")
                exitProcess(0)
            }

            if (statement is EndStatement) {
                return
            }
        }

        throw RuntimeException("Expected more instructions or for program to finish with an end statement")
    }

    fun jumpToClosingBrace() {
        var braceCounter = 1
        while (braceCounter != 0) {
            when (statements[pointer]) {
                is IfStatement -> braceCounter += 1
                is ClosingBraceStatement -> braceCounter -= 1
            }
            pointer += 1
        }
    }

    fun goToLabel(labelName: String) {
        pointer =
            statements.indexOfFirst { it is LabelStatement && (it.name.heldValue as ASTNodeValue.EvaluatedValue).evaluatedValue.value == labelName }
    }
}