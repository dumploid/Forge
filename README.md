# Forge
The forge language is a bare bones language, with easy to add syntax.

The base language contains minimal features, those being:
 - Ability to declare primitives
 - If statements
 - GoTo statements
 - Labels
 - Ability to declare tokens
 - Ability to declare statement syntax
 - Ability to run custom statements

The latter 3 points are what set apart this language.

# Code Examples
The below examples are theoretical, and have not been introduced into the language.

To declare a token: 
```
Token(<tokenName>, <regex>)
```

To declare a statement: 
```
<referencedTokenName: tokeType> -> //valid expression
```

For example, if parser.statements will be formatted as:
```
Token(ifToken, keyWordToken("if"))

<contents: BooleanExpression> -> if(contents){#_}
```
