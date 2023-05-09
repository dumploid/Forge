package environment

import parser.ForgeEvaluationException
import parser.statements.Statement
import parser.statements.statement_impl.ClosingBraceStatement
import parser.statements.statement_impl.EndStatement
import parser.statements.statement_impl.IfStatement
import parser.statements.statement_impl.LabelStatement

class Interpreter(val statements: List<Statement>) {
    private var pointer = 0
    val variableSpace = VariableSpace()
    val stack = mutableListOf<Any>()

    fun execute() {
        while (pointer < statements.size) {
            val statement = statements[pointer]
            pointer += 1
            try {
                statement.run()
            } catch (e: ForgeEvaluationException) {
                println("Failure to evaluate: " + e.message)
            }
            if (statement is EndStatement) {
                return
            }
        }

        throw RuntimeException("Expected more instructions or for program to finish with an end statement")
    }

    fun jumpToClosingBrace() {
        var braceCounter = 1
        while(braceCounter != 0) {
            when (statements[pointer]) {
                is IfStatement -> {
                    braceCounter+=1
                }
                is ClosingBraceStatement -> {
                    braceCounter-=1
                }
            }
            pointer += 1
        }
    }

    fun goToLabel(labelName: String) {
        pointer = statements.indexOfFirst { it is LabelStatement && it.name.heldValue.value == labelName }
    }
}