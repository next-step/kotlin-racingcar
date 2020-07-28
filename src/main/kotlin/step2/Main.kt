package step2

import java.util.*

fun main() {
    StringCalculator.parsing(
        stringExpression = Scanner(System.`in`).nextLine(),
        result = { expressionPair ->
            println(StringCalculator.evaluate(expressionPair.first, expressionPair.second))
        })
}