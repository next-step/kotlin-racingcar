package racingcar.model

/**
 * 전진을 위한 점수를 저장한 클래스.
 * Created by Jaesungchi on 2022.05.15..
 */
data class Dice(val score: Int) {
    fun isCanRunScore(): Boolean = score >= SCORE_OF_CAN_GO

    companion object {
        private const val MINIMUM_SCORE = 0
        private const val MAXIMUM_SCORE = 9
        private const val SCORE_OF_CAN_GO = 4

        fun fromRandom(): Dice {
            return Dice((MINIMUM_SCORE..MAXIMUM_SCORE).random())
        }
    }
}