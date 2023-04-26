import environment.Interpreter
import parser.Parser
import tokens.Tokenizer
import java.io.BufferedReader
import java.io.File

lateinit var interpreter: Interpreter

fun main() {
    about()

    println("Below is an example showing the statements of the input program and the variable environment")
    val bufferedReader: BufferedReader = File("src/program.txt").bufferedReader()
    val inputProgram = bufferedReader.use { it.readText() }

    println("input program:")
    println(inputProgram)

    val tokens = Tokenizer(inputProgram).tokenize()
    val statements = Parser.parseTokenList(tokens).heldStatements
    interpreter = Interpreter(statements)
    interpreter.execute()

    println("final variable state:")
    println(interpreter.variableSpace.currentBlock().heldValues)
}

fun about() {
    println("""The forge language is a bare bones language.

The base language will contain minimal features, those being:
 - Ability to declare primitives
 - If statements
 - GoTo statements
 - Labels
 """)
}