package racingcar

import number.Numbers.START_INDEX
import number.Numbers.makeRandomsToRacing
import printer.ResultView
import java.util.stream.IntStream

class RacingCars(private var cars: Cars) {
    fun racing(attempts: Int) {
        IntStream.range(START_INDEX, attempts)
            .forEach {
                cars = cars.forwardAllByCondition(makeRandomsToRacing(cars.getSize()))
                ResultView.printCarsPath(cars.retrieveCars())
                println()
            }
    }
}
