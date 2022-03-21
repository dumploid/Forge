import parser.Parser
import tokens.Tokenizer

fun main() {
    //checks all tokens are matched:
    Tokenizer().tokenize("\"String con7ents\" 0b140 Int Long Short Byte name == >= <= || && [](){} << >> + - * / % & | ^ < > =")
}