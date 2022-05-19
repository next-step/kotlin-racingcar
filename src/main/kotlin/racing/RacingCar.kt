package racing

-class RacingCar(round: Int, val name: String) {
    init {
        validateName(name)
    }
    companion object {
        const val MOVE_PIVOT = 4
        const val MOVE = 1
        const val NEXT_ROUND = 1
        const val INITIALIZE_VALUE = 0
        private const val MAX_CAR_NAME_LENGTH = 5
    }

    private val _distances = MutableList(round) { INITIALIZE_VALUE }
    val distances: List<Int>
        get() = this._distances.toList()

    private var currentRound = INITIALIZE_VALUE

    fun race(movePoint: Int) {
        if (canMove(movePoint)) {
            move()
        }
        currentRound += NEXT_ROUND
    }

    private fun move() {
        _distances[currentRound] = MOVE
    }

    private fun canMove(movePoint: Int): Boolean {
        return movePoint >= MOVE_PIVOT
    }

    private fun validateName(name: String) {
        require(name.length <= MAX_CAR_NAME_LENGTH) { "자동차 이름이 ${MAX_CAR_NAME_LENGTH}자를 초과하였습니다" }
        require(name.isNotBlank()) { "자동차 이름이 비어있습니다" }
    }
}
