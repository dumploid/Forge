package tokens.keywords

import tokens.keywords.built_in_types.*

object BuiltInImpl {
    val builtInList = arrayOf(
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