package racing.view

class RacingCar(val name: String) {
    private val _distances = mutableListOf<Int>()
    val distances: List<Int>
        get() = this._distances.toList()

    init {
        validateName(name)
    }
    fun race(movePoint: Int) {
        val isMove = canMove(movePoint)
        move(isMove)
    }

    private fun move(isMove: Boolean) {
        val result = if (isMove) MOVE else STOP
        _distances.add(result)
    }

    private fun canMove(movePoint: Int): Boolean {
        return movePoint >= MOVE_PIVOT
    }

    private fun validateName(name: String) {
        require(name.length <= MAX_CAR_NAME_LENGTH) { "자동차 이름이 ${MAX_CAR_NAME_LENGTH}자를 초과하였습니다" }
        require(name.isNotBlank()) { "자동차 이름이 비어있습니다" }
    }

    companion object {
        const val MOVE_PIVOT = 4
        const val MOVE = 1
        const val STOP = 0
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
