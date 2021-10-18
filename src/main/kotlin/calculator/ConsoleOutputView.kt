package calculator

object ConsoleOutputView {

    fun printResult(result: Double) {
        println("결과는 ${String.format("%.5f", result)}입니다.")
    }
}
