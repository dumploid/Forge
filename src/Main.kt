import environment.VariableSpace
import parser.Parser
import tokens.Tokenizer
import java.io.BufferedReader
import java.io.File

fun main() {
    val bufferedReader: BufferedReader = File("src/program.txt").bufferedReader()
    val inputProgram = bufferedReader.use { it.readText() }

    println("input program:")
    println(inputProgram)

    val tokens = Tokenizer(inputProgram).tokenize()
    val statements = Parser.parseTokenList(tokens).heldStatements

    for (statement in statements) {
        println(statement)
        statement.run()
    }

    println(VariableSpace.currentBlock().heldValues)
}