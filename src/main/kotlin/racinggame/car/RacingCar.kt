package racinggame.car

class RacingCar(
    val name: String,
    private val engine: Engine
) {
    var distance = 0
        private set

    fun move() {
        if (engine.enoughPower()) {
            distance++
        }
    }
}
