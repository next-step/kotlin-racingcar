package step2

import java.io.BufferedReader
import java.io.InputStreamReader

class Monitor {
    companion object {
        fun print(value: Double) {
            if (value - value.toLong() == 0.0) {
                println(value.toLong())
                return
            }
            println(value)
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val calculator = Calculator()
    val result = calculator.calculate(br.readLine())
    Monitor.print(result)
}
