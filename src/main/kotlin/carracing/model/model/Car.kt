package carracing.model.model

import kotlin.random.Random

typealias CarTrace = String

private const val MOVEMENT = "-"

data class Car(val carNumber: Int) {
    private var countOfMovementInRacing = 0

    fun move() {
        if (Random.nextInt(10) > 4) {
            countOfMovementInRacing++
        }
    }

    fun getTrace(): CarTrace = MOVEMENT.repeat(countOfMovementInRacing)
}
