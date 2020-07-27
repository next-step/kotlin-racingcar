package racingcar

object ResultView {
    private const val DISTANCE_MARK = "-"
    private const val TEXT_RACING_RESULT = "실행 결과"

    fun print(trial: Int, cars: List<RacingCar>) {
        if (trial == 1) println("\n$TEXT_RACING_RESULT")
        
        cars.forEach { car ->
            repeat(car.distance) { print(DISTANCE_MARK) }
            println()
        }
        println()
    }
}
