package racingcar

import number.Numbers.START_INDEX
import number.Numbers.makeRandomsToRacing
import printer.ResultView
import java.util.stream.IntStream

class RacingCars(private var cars: List<Car>) {
    companion object {
        private const val MAX_FORWARD_CONDITION = 4
    }

    fun racing(attempts: Int) {
        IntStream.range(START_INDEX, attempts)
            .forEach {
                cars = forwardAllByCondition(makeRandomsToRacing(cars.size))
                ResultView.printCarsPath(cars)
                println()
            }
    }

    fun forwardAllByCondition(conditions: List<Int>): List<Car> {
        return cars.mapIndexed {
            index, car ->
            forwardByCondition(car, conditions[index])
        }.toList()
    }

    fun forwardByCondition(car: Car, condition: Int): Car {
        if (canForward(condition)) {
            car.forward()
        }

        return car
    }

    private fun canForward(condition: Int) = condition >= MAX_FORWARD_CONDITION
}
