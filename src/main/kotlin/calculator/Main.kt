package calculator

import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val input = nextLine()
    println(StringCalculator.calc(input))
}
