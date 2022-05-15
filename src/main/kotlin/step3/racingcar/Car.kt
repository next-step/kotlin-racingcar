package step3.racingcar

class Car(
    private val engine: Engine
) {
    private val _movements: MutableList<Boolean> = mutableListOf()

    val movements
        get() = _movements.toList()

    fun move() {
        _movements.add(engine.move())
    }
}
