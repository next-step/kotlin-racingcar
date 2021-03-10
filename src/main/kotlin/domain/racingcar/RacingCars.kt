package domain.racingcar

class RacingCars(private var cars: Cars, val conditions: Conditions) {
    init {
        require(cars.getSize() == conditions.getSize()) { "전진 조건의 개수와 자동차의 개수가 같지 않습니다." }
    }

    fun racing(attempts: Int): OverallResult {
        val allRound = mutableListOf<Records>()

        repeat(attempts) {
            cars.forwardAllByCondition(conditions)
            allRound.add(cars.finishRound())
        }

        return OverallResult(allRound)
    }
}
