package racing.model

class Position(
    position: Int
) {
    var position = position
        private set

    init {
        this.position = position.coerceAtLeast(MIN_POSITION)
    }

    fun plusOne() {
        this.position += 1
    }

    companion object {
        private const val MIN_POSITION = 0
    }
}
