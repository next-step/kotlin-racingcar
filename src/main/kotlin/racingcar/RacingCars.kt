package racingcar

import number.Numbers.makeRandomsToRacing

class RacingCars(private var cars: Cars) {
    fun racing(attempts: Int): List<List<Int>> {
        val allRoundPositions = ArrayList<List<Int>>()

        repeat(attempts) {
            cars.forwardAllByCondition(makeRandomsToRacing(cars.getSize()))
            allRoundPositions.add(cars.getPositions())
        }

        return allRoundPositions
    }
}
