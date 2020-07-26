package racingcar

object ResultView {
    fun print(cars: MutableList<RacingCar>) {
        cars.forEach {
            println("${it.distance}")
        }
        println()
    }
}
