package tokens.patterns.keywords

object BooleanKeyword : Keyword("Boolean")

object ByteKeyword : Keyword("Byte")

object CharKeyword : Keyword("Char")

object DoubleKeyword : Keyword("Double")

object FloatKeyword : Keyword("Float")

object IntKeyword : Keyword("Int")

object LongKeyword : Keyword("Long")

object ShortKeyword : Keyword("Short")

object StringKeyword : Keyword("String")

object BuiltInImpl {
    val builtInImpl = arrayOf(
        BooleanKeyword,
        ByteKeyword,
        CharKeyword,
        DoubleKeyword,
        FloatKeyword,
        IntKeyword,
        LongKeyword,
        ShortKeyword,
        StringKeyword
    )
}