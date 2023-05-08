package parser

import java.lang.RuntimeException

class ForgeEvaluationException(evaluated: String, found: String) :
    RuntimeException("Unable to evaluate: $evaluated, found $found")