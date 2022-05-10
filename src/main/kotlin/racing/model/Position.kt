package racing.model

class Position(
    var position: Int
) {

    init {
        validateMinPosition(position)
    }

    private fun validateMinPosition(position: Int) {
        require(position >= MIN_POSITION) { "위치값은 최소 $MIN_POSITION 이상이어야 합니다. (position: $position)" }
    }

    fun plusOne() {
        this.position += 1
    }

    companion object {
        private const val MIN_POSITION = 0
    }
}
