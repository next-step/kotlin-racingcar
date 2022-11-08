package racingcar

import racingcar.utils.RandomNumberGenerator

enum class MoveType(
    private val randomRange: IntRange,
    val movePosition: Int,
    private val moveConditionDescription: String,
) {
    DEFAULT((0..9), 1, "랜덤 값이 4이상 9이하 일 경우에만 1칸 전진 가능");

    private fun nextInt(): Int = RandomNumberGenerator.generate(this.randomRange)
    private val maxValue = this.randomRange.last

    companion object {
        private const val FORWARD_NUMBER = 4

        fun isPossibleMove(moveType: MoveType): Boolean =
            when (moveType) {
                DEFAULT -> (moveType.nextInt() in FORWARD_NUMBER..moveType.maxValue)
            }
    }
}
