package tokens

interface EvaluableToken<T> {
    fun evaluate(from: String): T
}