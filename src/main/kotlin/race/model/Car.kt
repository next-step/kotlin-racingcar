package race.model

data class Car(
    val name: String,
    val position: Int = START_POSITION
) {

    init {
        require(name.length < MAXIMUM_NAME_LENGTH) {
            "자동차 이름은 5자를 초과할 수 없다."
        }
    }

    fun move(count: Int): Car = if (count >= MOVE_CONDITION) {
        this.copy(position = position + 1)
    } else {
        this
    }

    companion object {
        const val START_POSITION = 0
        const val MOVE_CONDITION = 4
        const val MAXIMUM_NAME_LENGTH = 5
    }
}
