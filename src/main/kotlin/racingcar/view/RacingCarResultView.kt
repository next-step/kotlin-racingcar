package racingcar.view

object RacingCarResultView {
    fun printResult(result: List<List<Int>>, carNames: List<String>) {
        println()
        println("실행 결과")

        result.forEach { roundResult ->
            roundResult.forEachIndexed { index, position ->
                printPosition(carNames[index], position)
            }
            println()
        }
    }

    private fun printPosition(name: String, position: Int) {
        println("$name : " + "-".repeat(position))
    }
}
