package step3

class Car(
    private val engine: ConditionalOperatingCarEngine,
) {
    var movedDistance: Distance = Distance(0)
        private set

    fun move() {
        movedDistance += engine.move()
    }
}
