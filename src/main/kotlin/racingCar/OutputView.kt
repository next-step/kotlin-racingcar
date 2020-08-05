package racingCar

object OutputView {
    fun showResultMessage() {
        println("실행 결과")
    }

    fun showResult(cars: Cars) {
        for (car in cars.cars) {
            printCarDistance(car)
            println()
        }
        println()
    }

    private fun printCarDistance(car: Car) {
        repeat(car.distance) {
            print("-")
        }
    }
}
