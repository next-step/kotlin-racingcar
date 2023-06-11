package race

import kotlin.random.Random

class Car private constructor(var position: Int) {
    constructor() : this(0)

    fun copy(): Car {
        return Car(this.position)
    }

    fun move() {
        if (canGoStraight()) {
            straight()
        }
    }

    private fun canGoStraight(): Boolean {
        return 4 <= Random.nextInt(10)
    }

    private fun straight() {
        position++
    }
}
