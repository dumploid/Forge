package exceptions

class ForgeEvaluationException(evaluated: String, found: String) :
    ForgeException("Unable to evaluate: $evaluated, found $found")