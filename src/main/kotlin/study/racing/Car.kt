package study.racing

import kotlin.random.Random

/**
 * @author 이상준
 */
class Car {
    private var position: Int = 0

    fun getPosition(): Int {
        return this.position
    }

    fun move() {
        if (Random.nextInt(GameRule.MIN_RANDOM_POSITION, GameRule.MAX_RANDOM_POSITION) > 3) {
            this.position += 1
        }
    }
}
