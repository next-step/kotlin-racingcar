package racingcar.model

import kotlin.random.Random

/**
 * 자동차 경주자
 */
class CarRacer {

    var path: String = ""
        private set

    fun move(moveCount: Int) {
        if (moveCount < 4) return
        path += CHARACTER_MOVE
    }

    fun generateCount() = Random(System.currentTimeMillis()).nextInt(0, 10)

    companion object {
        const val CHARACTER_MOVE = "-"
    }
}
