package tokens.patterns.values

import tokens.EvaluableToken
import tokens.patterns.TokenPattern

abstract class AbstractValueTokenPattern<T> : TokenPattern, EvaluableToken<T>