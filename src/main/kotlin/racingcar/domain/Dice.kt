package racingcar.domain

/**
 * 전진을 위한 점수를 저장한 클래스.
 * Created by Jaesungchi on 2022.05.15..
 */
object Dice {
    private const val MINIMUM_SCORE = 0
    private const val MAXIMUM_SCORE = 9
    private const val SCORE_OF_CAN_GO = 4
    private const val POINT_MOVE = 1
    private const val POINT_STOP = 0

    fun rollDiceAndGetPoint(score: Int = rollDice()) = if (isCanRunScore(score)) POINT_MOVE else POINT_STOP

    private fun isCanRunScore(score: Int) = score >= SCORE_OF_CAN_GO
    
    private fun rollDice() = (MINIMUM_SCORE..MAXIMUM_SCORE).random()
}
