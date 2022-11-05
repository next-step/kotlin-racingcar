package racingcar.domain

import racingcar.view.InputView
import racingcar.view.ResultView
import kotlin.random.Random

const val RANDOM_MIN_NUM = 0
const val RANDOM_MAX_NUM = 9
const val RANDOM_CONDITION_NUM = 4

class Race(
    val round: Long
) : InputView, ResultView {
    fun moveRule() = Random.nextInt(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= RANDOM_CONDITION_NUM
}
