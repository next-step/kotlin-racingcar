package carracing.model.model

import kotlin.random.Random

typealias CarTrace = String

private const val MOVEMENT = "-"

data class Car(val carNumber: Int) {
    private var countOfMoveInRacing = 0

    fun move() {
        if (Random.nextInt(10) > 4) {
            countOfMoveInRacing++
        }
    }

    fun getTrace(): CarTrace = MOVEMENT.repeat(countOfMoveInRacing)
}
