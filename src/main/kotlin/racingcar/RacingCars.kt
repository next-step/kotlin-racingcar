package racingcar

import number.Numbers.makeRandomsToRacing

class RacingCars(private var cars: Cars) {
    fun racing(attempts: Int): List<Round> {
        val allRound = mutableListOf<Round>()

        repeat(attempts) {
            cars.forwardAllByCondition(makeRandomsToRacing(cars.getSize()))
            allRound.add(cars.finishRound())
        }

        return allRound
    }
}
