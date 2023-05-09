import environment.Interpreter
import parser.Parser
import parser.nodes.ASTNode
import parser.nodes.TreeBuilder
import tokens.Tokenizer
import java.io.BufferedReader
import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

lateinit var interpreter: Interpreter

fun main(args : Array<String>) {
    val bufferedReader: BufferedReader = File(args[0]).bufferedReader()
    val inputProgram = bufferedReader.use { it.readText() }

    val tokens = Tokenizer(inputProgram).tokenize()
    val evaluatedNodes =
        TreeBuilder(tokens.map { ASTNode(it, emptyList()) } as MutableList<ASTNode>).buildTrees()

    val statements = Parser.parseStatements(evaluatedNodes)
    interpreter = Interpreter(statements)
    println("Executed in " + TimeUnit.MILLISECONDS.convert(measureNanoTime {
        interpreter.execute()
    }, TimeUnit.NANOSECONDS) + " ms")

    println("final variable state:")
    println(interpreter.variableSpace.heldValues.map { x ->
        "(${x.key}, ${x.value.value})"
    })
}