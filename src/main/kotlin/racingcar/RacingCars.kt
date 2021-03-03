package racingcar

import number.Numbers.makeRandomsToRacing

class RacingCars(private var cars: Cars) {
    fun racing(attempts: Int): List<Positions> {
        val allRoundPositions = ArrayList<Positions>()

        repeat(attempts) {
            cars.forwardAllByCondition(makeRandomsToRacing(cars.getSize()))
            allRoundPositions.add(cars.getPositions())
        }

        return allRoundPositions
    }
}
