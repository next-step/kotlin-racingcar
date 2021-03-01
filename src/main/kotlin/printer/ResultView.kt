package printer

import racingcar.Car

object ResultView {
    fun printInt() {
        println("실행 결과")
    }

    fun printCarsPath(cars: List<Car>) {
        cars.forEach { car -> printCarPath(car) }
    }

    private fun printCarPath(car: Car) {
        for (count in 0..car.retrievePosition()) {
            print("-")
        }

        println()
    }
}
