package racingcar.model

data class RacingStadium(private val labs: Int) {

    init {
        require(labs >= 0) { "labs must be positive. but provided `$labs`" }
    }

    infix fun racing(cars: RacingCars): RacingHistory {
        val history = mutableListOf<RacingCars>()
        var currentCars: RacingCars = cars
        repeat(labs) {
            currentCars = currentCars.nextMoved
            history.add(currentCars)
        }
        return history
    }
}

typealias RacingHistory = Collection<RacingCars>
