package carracing



class Car(
    val name: String,
    var position: Int = INITIAL_POSITION,
    var isWinner: Boolean = false
) {

    init {
        require(name.length <= ALLOWED_LENGTH_CAR_NAME) { "Name cannot exceed 5 characters" }
    }

    fun move(random: Int) {
        if (random >= MOVE_NUMBER_THRESHOLD) {
            position++
        }
    }

    fun setAsWinner(maxPosition: Int) {
        isWinner = (position == maxPosition)
    }

    companion object {
        const val MOVE_NUMBER_THRESHOLD = 4
        const val INITIAL_POSITION = 0
        const val ALLOWED_LENGTH_CAR_NAME = 5
    }
}
