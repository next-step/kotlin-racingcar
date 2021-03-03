package study.racingcar.step4

class ResultView {

    private val SHOW_POSITION_CARACTOR = "-"

    fun render(cars: List<RacingRecord>) {
        println()
        for (car in cars) println(showFormat(car))
    }

    fun renderResult(winnerCarNames: String) {
        println()
        println("${winnerCarNames}가 최종 우승했습니다.")
    }

    private fun showFormat(car: RacingRecord): String {
        val showPosition = getShowPosition(car)
        return "${car.name} : $showPosition"
    }

    private fun getShowPosition(car: RacingRecord): String {
        return (1..car.position).joinToString(separator = "") { SHOW_POSITION_CARACTOR }
    }
}
