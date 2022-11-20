package racingcar

class ResultView {
    companion object {
        fun view(cars: List<Car>) {
            for (car in cars) {
                if (car.position == 0) println("x")
                else println("-".repeat(car.position))
            }
            println()
        }
    }
}
