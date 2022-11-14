package racing.domain

import racing.dto.RacingCarInfo
import kotlin.random.Random
import kotlin.random.nextInt

class RacingCar {
    var position: Int = 1
        private set

    companion object {
        private const val THRESHOLD = 4
        val RANDOM_RANGE = 0..9

        fun create(num: Int): List<RacingCar> =
            buildList {
                for (i in 0 until num) {
                    this.add(RacingCar())
                }
            }
    }

    fun moveForward() {
        val random = Random.nextInt(RANDOM_RANGE)
        if (random >= THRESHOLD) {
            position++
        }
    }

    fun mapToRacingCarInfo(): RacingCarInfo {
        return RacingCarInfo(this.position)
    }
}
