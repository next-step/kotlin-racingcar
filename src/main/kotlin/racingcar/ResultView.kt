package racingcar

object ResultView {
    init {
        println("실행 결과")
    }

    fun showRaceResult(result: List<Car>) {
        result.forEach { car ->
            repeat(car.position) { print("-") }
            println()
        }
        println()
    }
}
