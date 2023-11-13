package carracing.dto

import carracing.CarRacingValidator

data class Car(
    val name: String,
) {
    init {
        CarRacingValidator().validateCarName(this.name)
    }
    var position: Int = 0
        private set

    fun move() {
        position++
    }
}