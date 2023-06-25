package racingcar.domain

import kotlin.random.Random

class RacingCarEngine : Engine {
    override fun movePossible(): Boolean {
        return Random.nextInt(0, 10) >= RacingCar.MOVE_POSSIBLE_NUMBER
    }
}
