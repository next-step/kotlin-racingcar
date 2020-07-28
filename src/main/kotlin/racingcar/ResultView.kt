package racingcar

object ResultView {
    private const val DISTANCE_MARK = "-"
    private const val TEXT_RACING_RESULT = "실행 결과"

    fun showResultTitle() = println("\n$TEXT_RACING_RESULT")

    fun showRace(cars: List<RacingCar>) {
        cars.forEach { car ->
            repeat(car.getTotalDistance()) { print(DISTANCE_MARK) }
            println()
        }
        println()
    }
}
