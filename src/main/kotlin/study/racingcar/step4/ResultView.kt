package study.racingcar.step4

class ResultView {

    private val SHOW_POSITION_CARACTOR = "-"

    fun render(cars: List<RacingCarStatus>) {
        println()
        for (car in cars) println(showFormat(car))
    }

    fun renderResult(cars: List<RacingCarStatus>) {
        val maxPosition = cars.maxBy { car -> car.position }!!.position
        val winnerCarNameList = cars.filter { car -> car.position == maxPosition }
            .joinToString { car -> car.name }
        println()
        println("${winnerCarNameList}가 최종 우승했습니다.")
    }

    private fun showFormat(car: RacingCarStatus): String {
        val showPosition = getShowPosition(car)
        return "${car.name} : $showPosition"
    }

    private fun getShowPosition(car: RacingCarStatus): String {
        return (1..car.position).joinToString(separator = "") { SHOW_POSITION_CARACTOR }
    }
}
