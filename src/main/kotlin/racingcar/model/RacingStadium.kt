package racingcar.model

import racingcar.model.RacingCar.Companion.nextMoved

data class RacingStadium(private val labs: Int) {

    init {
        require(labs >= 0) { "labs must be positive. but provided `$labs`" }
    }

    infix fun racing(cars: Collection<RacingCar>): RacingHistory {
        val history = mutableListOf<Collection<RacingCar>>()
        var currentCars: Collection<RacingCar> = cars
        repeat(labs) {
            currentCars = currentCars.nextMoved
            history.add(currentCars)
        }
        return history
    }
}

typealias RacingHistory = Collection<Collection<RacingCar>>
