package view.calculator

class OutputView private constructor() {
    companion object {
        fun printResult(result: Int) {
            println("결과: $result")
        }
    }
}
