package racingcar.model

object TestCarFactory {
    fun createMovingCar(name: String) = Car(name, movingStrategy = forwardMovingStrategy)

    fun createStationaryCar(name: String) = Car(name, movingStrategy = noMovingStrategy)

    private val forwardMovingStrategy = object : MovingStrategy {
        override fun tryMove(): Boolean = true
    }

    private val noMovingStrategy = object : MovingStrategy {
        override fun tryMove(): Boolean = false
    }
}
