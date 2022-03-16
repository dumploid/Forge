import tokens.Tokenizer

fun main() {
    Tokenizer().tokenize("").forEach{
        println(it)
    }
}