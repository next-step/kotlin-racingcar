package domain.racingcar

class RacingCars(private var cars: Cars, private val conditions: Conditions) {
    fun racing(attempts: Int): OverallResult {
        val allRound = mutableListOf<Records>()

        repeat(attempts) {
            allRound.add(cars.forwardAllByCondition(conditions))
        }

        return OverallResult(allRound)
    }
}
