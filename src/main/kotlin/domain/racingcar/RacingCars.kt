package domain.racingcar

class RacingCars(private var cars: Cars, private val conditions: Conditions) {
    fun racing(attempts: Int): OverallResult {
        val allRound = mutableListOf<Records>()

        repeat(attempts) {
            cars.forwardAllByCondition(conditions)
            allRound.add(cars.finishRound())
        }

        return OverallResult(allRound)
    }
}
