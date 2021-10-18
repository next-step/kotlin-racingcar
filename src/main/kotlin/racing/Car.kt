package racing

class Car(private val engine: Engine) {

    var position: Position = INITIAL_POSITION
        private set

    fun go() {
        if (engine.canMove()) {
            position = position.forward()
        }
    }
}
