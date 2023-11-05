package racing

import kotlin.random.Random

open class Car(
    var position: Int = 0
) {

    open fun moveOrNot(): Boolean {
        return Random.nextInt(10) > 4
    }

    fun move() {
        if (moveOrNot()) {
            position += 1
        }
    }
}
