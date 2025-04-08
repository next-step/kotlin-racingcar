package carracing.game.domain.data

private const val INITIAL_POSITION = 0
private const val MIN_NUMBER_TO_MOVE = 4

class Car private constructor(
    var position: Int,
    val name: String,
    private val generateMoveNumber: () -> Int,
) {
    fun move() {
        if (generateMoveNumber() >= MIN_NUMBER_TO_MOVE) {
            position++
        }
    }

    companion object {
        fun of(
            position: Int = INITIAL_POSITION,
            name: String?,
            generateMoveNumber: () -> Int,
        ): Car = Car(position = position, name = validateName(name), generateMoveNumber = generateMoveNumber)

        private fun validateName(name: String?): String {
            val trimmedName = name?.trim()
            require(!trimmedName.isNullOrBlank() && trimmedName.length <= NAME_MAX_LENGTH) {
                "Name is required and should not exceed $NAME_MAX_LENGTH chars"
            }
            return trimmedName
        }

        private const val NAME_MAX_LENGTH = 5
    }
}
