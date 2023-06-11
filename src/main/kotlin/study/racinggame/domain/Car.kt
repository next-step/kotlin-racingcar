package study.racinggame.domain

class Car(val name: String, private val engine: CarEngine) {
    private var position: Int = 1

    fun move(): CarPosition {
        position += engine.run()
        return CarPosition(name, position)
    }
}

data class CarPosition(val name: String, val position: Int)
