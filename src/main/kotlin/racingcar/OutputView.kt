package racingcar

class OutputView {
    fun printResult() {
        println("실행 결과")
    }

    fun printPosition(position: Int): String {
        return "-".repeat(position)
    }
}
