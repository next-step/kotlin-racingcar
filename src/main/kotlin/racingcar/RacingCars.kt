package racingcar

import number.Numbers.makeRandomsToRacing

class RacingCars(private var cars: Cars) {
    fun racing(attempts: Int): List<Int> {
        repeat(attempts) {
            cars.forwardAllByCondition(makeRandomsToRacing(cars.getSize()))
        }

        return cars.getPositions()
    }
}
