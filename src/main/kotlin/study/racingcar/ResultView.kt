package study.racingcar

object ResultView {

    private const val MOVE_CHARACTER = "-"

    fun outputResultString() {
        println("실행 결과")
    }

    fun outputResult(result: List<Car>) {
        result.forEach {
            distanceToString(it.distance)
        }
        println()
    }

    private fun distanceToString(distance: Int) {
        for (i in 0 until distance) {
            print(MOVE_CHARACTER)
        }
        println()
    }
}
