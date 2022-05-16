package step4.racingcar.racingcar

class Car(
    val racerName: String,
    private val engine: Engine
) {
    private val _movements: MutableList<Boolean> = mutableListOf()

    val movements
        get() = _movements.toList()

    fun move() {
        _movements.add(engine.move())
    }
}
