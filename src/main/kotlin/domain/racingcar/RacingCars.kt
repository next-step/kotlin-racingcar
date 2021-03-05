package domain.racingcar

import domain.number.Numbers.makeRandomsToRacing

class RacingCars(private var cars: Cars) {
    fun racing(attempts: Int): OverallResult {
        val allRound = mutableListOf<Records>()

        repeat(attempts) {
            cars.forwardAllByCondition(makeRandomsToRacing(cars.getSize()))
            allRound.add(cars.finishRound())
        }

        return OverallResult(allRound)
    }
}
