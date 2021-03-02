package study.racingcar

object ResultView {

    private const val MOVE_CHARACTER = "-"

    fun outputResultString() {
        println("실행 결과")
    }

    fun outputResult(result: List<Car>) {
        result.forEach {
            distanceToString(it.name, it.distance)
        }
        println()
    }

    fun outputWinner(winners: List<String>) {
        println("${winners.joinToString(", ")} 가 최종 우승 했습니다.")
    }

    private fun distanceToString(carName: String, distance: Int) {
        print("$carName : ")
        for (i in 0 until distance) {
            print(MOVE_CHARACTER)
        }
        println()
    }
}
