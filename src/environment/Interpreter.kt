package environment

import parser.statements.Statement
import parser.statements.statement_impl.ClosingBraceStatement
import parser.statements.statement_impl.IfStatement

class Interpreter(val statements: List<Statement>) {
    private var pointer = 0
    val variableSpace = VariableSpace()

    fun execute() {
        while (pointer < statements.size) {
            val statement = statements[pointer]
            pointer += 1

            println(statement)
            statement.run()
        }
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

}