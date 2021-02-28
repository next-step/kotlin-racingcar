package racingcar.model

import racingcar.Constants.CRITERIA_NUMBER
import racingcar.`interface`.CarBehavior

class Car(
    private var currentProgress: Int = 0
) : CarBehavior {
    fun getProgress(): Int {
        return currentProgress
    }

    override fun moveForward() {
        currentProgress += 1
    }

    override fun checkPossibleToMove(randomNumber: Int): Boolean {
        return randomNumber >= CRITERIA_NUMBER
    }
}
