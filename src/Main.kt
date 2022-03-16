import tokens.Tokenizer
import tokens.structure.TokenGrouping

fun main() {
    println(Tokenizer().tokenize("int \"Hello!\" int \"Hi!\""))
    val x = TokenGrouping()
    x.tokenHolderEquals(x)
}