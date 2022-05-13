package racing.domain

class CarRacing(
    private val cars: RacingCars,
    private val moveCount: Int
) {
    init {
        checkValidation()
    }

    fun run(
        onStart: (cars: RacingCars) -> Unit = {},
        onTurnEnd: (cars: RacingCars) -> Unit = {},
        onFinish: (winners: Winners) -> Unit = {}
    ) {
        onStart(cars)

        repeat(moveCount) {
            cars.moveAll()
            onTurnEnd(cars)
        }

        onFinish(cars.findWinners())
    }

    @Throws(IllegalArgumentException::class)
    private fun checkValidation() {
        require(moveCount >= MIN_MOVE_COUNT) { "이동은 $MIN_MOVE_COUNT 이상을 입력해야 합니다." }
    }

    companion object {
        private const val MIN_MOVE_COUNT = 0
    }
}
