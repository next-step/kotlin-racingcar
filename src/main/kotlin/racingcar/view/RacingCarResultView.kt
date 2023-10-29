package racingcar.view

object RacingCarResultView {
    fun printResult(result: List<List<Int>>) {
        println("실행 결과")

        result.forEach { roundResult ->
            roundResult.forEach {
                printPosition(it)
            }
            println()
        }
    }

    private fun printPosition(position: Int) {
        println("-".repeat(position))
    }
}
