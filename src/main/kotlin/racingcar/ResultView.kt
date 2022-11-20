package racingcar

object ResultView {
    fun print(cars: List<Car>) {
        for (car in cars) {
            val location = car.location
            repeat(location) { print("-") }
            println()
        }
        println()
    }
}
