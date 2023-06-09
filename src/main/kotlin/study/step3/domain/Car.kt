package study.step3.domain

class Car(private val engine: CarEngine) {
    var position: Int = 1
        private set

    fun move() {
        position += engine.run()
    }
}
