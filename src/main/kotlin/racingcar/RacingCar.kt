package racingcar

import java.util.Random

class RacingCar(val carName: String, var carDistance: String = "") {
    var randomMovingCount = 0
    fun randomMoving() {
        randomMovingCount++
        if (Random().nextInt(10) > 4) {
            carDistance += "-"
        }
    }
}
