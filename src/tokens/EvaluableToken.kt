package tokens

interface EvaluableToken<T> {
    abstract fun evaluate(from: String): T
}