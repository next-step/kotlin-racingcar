package printer

import number.Numbers.START_INDEX
import racingcar.Car
import java.util.stream.IntStream

object ResultView {
    fun printInt() {
        println("실행 결과")
    }

    fun printCarsPath(cars: List<Car>) {
        cars.forEach { car -> printCarPath(car) }
    }

    private fun printCarPath(car: Car) {
        IntStream.range(START_INDEX, car.retrievePosition())
            .forEach {
                print("-")
            }

        println()
    }
}
