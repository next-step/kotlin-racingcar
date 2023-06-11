package study.racinggame.domain

class Car(private val engine: CarEngine) {
    private var position: Int = 1

    fun move(): Int {
        position += engine.run()
        return position
    }
}
