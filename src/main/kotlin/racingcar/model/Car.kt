package racingcar.model

open class Car(position: Int = DEFAULT_POSITION, private val movingStrategy: MovingStrategy = RandomMovingStrategy()) {
    constructor(car: Car) : this(car.position)

    var position: Int = position
        private set

    fun move() {
        if (movingStrategy.tryMove()) position++
    }

    companion object {
        private const val DEFAULT_POSITION: Int = 0
    }
}
