package racingcar

class ResultView {
    companion object {
        fun print(cars: List<Car>) {
            for (car in cars) {
                val location = car.currentLocation()
                repeat(location) { print("-") }
                println()
            }
            println()
        }
    }
}
