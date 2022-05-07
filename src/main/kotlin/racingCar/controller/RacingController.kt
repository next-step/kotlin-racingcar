package racingCar.controller

import java.util.Random

/**
 * 레이싱을 시작하고, 계산하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RacingController {
    private fun rollTheDice(): Int {
        val random = Random()
        return random.nextInt(DICE_SIZE)
    }

    private fun checkCanRunScore(score: Int): Boolean {
        return score >= SCORE_OF_CAN_GO
    }

    companion object {
        private val DICE_SIZE = 10
        private val SCORE_OF_CAN_GO = 4
    }
}
