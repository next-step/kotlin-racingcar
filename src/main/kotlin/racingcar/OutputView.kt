package racingcar

object OutputView {

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printResult(result: List<Car>) {
        result.forEach {
            println("-".repeat(it.position))
        }
        println()
    }
}
