package racinggame.car

class RacingCar(private val engine: Engine) {
    private var distance = 0

    fun move() {
        if (engine.enoughPower()) {
            distance++
        }
    }

    fun distance(): Int {
        return this.distance
    }
}
