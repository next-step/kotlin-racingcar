package racingcar

import java.util.Random

class RacingCar(val carName: String, var carDistance: Int = 0) {
    fun randomMoving() {
        if (Random().nextInt(10) > 4) {
            carDistance += 1
        }
    }
}
