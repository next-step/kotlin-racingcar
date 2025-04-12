package carracing.game.domain.data

private const val INITIAL_POSITION = 0
private const val MIN_NUMBER_TO_MOVE = 4
const val NAME_MAX_LENGTH = 5

class Car(
    position: Int = INITIAL_POSITION,
    name: String,
    private val generateMoveNumber: () -> Int,
) {
    var position: Int = position
        private set

    val name: String = validateName(name)

    fun move() {
        if (generateMoveNumber() >= MIN_NUMBER_TO_MOVE) {
            position++
        }
    }

    override fun toString(): String = "Car(name='$name', position=$position)"

    private fun validateName(name: String?): String {
        val trimmedName = name?.trim()
        require(!trimmedName.isNullOrBlank() && trimmedName.length <= NAME_MAX_LENGTH) {
            "Name is required and should not exceed $NAME_MAX_LENGTH chars"
        }
        return trimmedName
    }
}
