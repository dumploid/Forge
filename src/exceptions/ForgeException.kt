package exceptions

import java.lang.RuntimeException

open class ForgeException(exceptionMessage: String): RuntimeException(exceptionMessage)