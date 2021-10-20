package racing

class Car(private val engine: Engine, val name: CarName) {

    var position: Position = INITIAL_POSITION
        private set

    fun go() {
        if (engine.canMove()) {
            position = position.forward()
        }
    }
}
