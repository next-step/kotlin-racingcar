package racing.model

class Position(
    var position: Int
) {

    init {
        position = position.coerceAtLeast(MIN_POSITION)
    }

    fun plusOne() {
        this.position += 1
    }

    companion object {
        private const val MIN_POSITION = 0
    }
}
