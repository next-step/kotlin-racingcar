package racing.domain

import racing.generator.NumberGenerator

class Car(
    name: String = "car",
    val moveNumber: NumberGenerator
) {
    val carName = CarName(name)

    var position: Int = 0
        private set

    fun move() {
        if (moveCheck()) {
            position++
        }
    }

    private fun moveCheck(): Boolean {
        return this.moveNumber.nextInt(10) >= 4
    }
}
