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
    println(Parser.parseTokenList(tokens).heldStatements)
}