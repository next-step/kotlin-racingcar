package car_race.logic

class GameRound private constructor(
    val value: Long
) {

    companion object {
        private const val INVALID_TYPE_MESSAGE = "게임 횟수는 양의 정수여야 합니다."

        fun from(input: String): GameRound {
            validate(input)

            return GameRound(input.toLong())
        }

        private fun validate(input: String) {
            try {
                input.toLong()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(
                    INVALID_TYPE_MESSAGE,
                    e
                )
            }
            check(input.toLong() > 0) { throw IllegalArgumentException(INVALID_TYPE_MESSAGE) }
        }
    }
}
