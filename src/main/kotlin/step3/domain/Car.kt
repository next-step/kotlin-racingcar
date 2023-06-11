package step3.domain

class Car(
    private val engine: ConditionalOperatingCarEngine,
    val name: CarName,
) {

    var movedDistance: Distance = Distance(0)
        private set

    fun move() {
        movedDistance += engine.move()
    }
}
