package calculator

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val calculator = ArithmeticCalculator()

    var input = reader.readLine()
    while (input != null) {
        try {
            println("$input = ${calculator.calculate(input)}")
        } catch (e: Exception) {
            println("Error occurred: $e")
        }
        input = reader.readLine()
    }
}
