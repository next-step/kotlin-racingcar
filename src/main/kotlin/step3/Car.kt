package step3

class Car(
    private val engine: CarEngine,
    private var movedDistance: Distance = Distance(0),
) {
    fun move() {
        movedDistance += engine.move()
    }

    fun showMovedDistance(): Distance {
        return movedDistance
    }
}
