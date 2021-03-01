package racing.domain

private const val DEFAULT_POSITION = 0
private const val MAX_NAME_LENGTH = 5

internal class Car(name: String = "", position: Int = DEFAULT_POSITION) {
    init {
        require(name.trim().length <= MAX_NAME_LENGTH) {
            "The maximum name length is 5"
        }
    }

    val name = name.trim()
    var position: Int = position
        private set

    fun tryMove(movable: Movable) {
        if (movable.isMovable()) {
            this.position++
        }
    }
}
