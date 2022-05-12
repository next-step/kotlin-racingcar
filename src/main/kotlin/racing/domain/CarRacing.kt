package racing.domain

object CarRacing {

    private const val MIN_MOVE_COUNT = 0

    fun run(
        cars: List<Car>,
        moveCount: Int,
        onStart: (cars: List<Car>) -> Unit = {},
        onTurnEnd: (cars: List<Car>) -> Unit = {},
        onFinish: (winners: List<Car>) -> Unit = {}
    ) {
        checkValidation(moveCount)

        onStart(cars)

        repeat(moveCount) {
            nextTurn(cars)
            onTurnEnd(cars)
        }

        onFinish(findWinners(cars))
    }

    @Throws(IllegalArgumentException::class)
    private fun checkValidation(moveCount: Int) {
        require(moveCount >= MIN_MOVE_COUNT) { "이동은 $MIN_MOVE_COUNT 이상을 입력해야 합니다." }
    }

    private fun nextTurn(cars: List<Car>) {
        cars.forEach(Car::move)
    }

    private fun findWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { maxPosition == it.position }
    }
}
