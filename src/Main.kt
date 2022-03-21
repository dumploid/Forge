
import parser.Parser
import tokens.Tokenizer
import java.io.File
import java.io.BufferedReader

fun main() {
    val bufferedReader: BufferedReader = File("src/program.txt").bufferedReader()
    val inputProgram = bufferedReader.use { it.readText() }

    println("input program:")
    println(inputProgram)

    val tokens = Tokenizer().tokenize(inputProgram)
    println(Parser.parseTokenList(tokens).heldStatements)
}