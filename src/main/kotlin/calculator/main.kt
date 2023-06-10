package calculator

fun main() {
    while (true) {
        val input = readln()

        if (input == "END") {
            break
        }

        try {
            println("$input = ${Calculator.calculate(input)}")
        } catch (e: IllegalArgumentException) {
            println("입력 값이 잘못되었습니다")
        }
    }
}
