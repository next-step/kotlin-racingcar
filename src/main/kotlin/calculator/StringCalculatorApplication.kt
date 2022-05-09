package calculator

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val value = scanner.nextLine().toString()

    val expressions = StringCalculator(value)
        .getValues()

    println(Expression(expressions).calculate())
}
