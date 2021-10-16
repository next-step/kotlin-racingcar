package step2

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
    val br = readLine()
    val parser = Parser(" ")
    val calculator = Calculator(parser)
    val result = calculator.calculate(br)
    Monitor.print(result)
}
