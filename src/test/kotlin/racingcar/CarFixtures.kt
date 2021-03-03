package racingcar

object CarFixtures {
    fun createAlwaysMovingCar(): Car {
        return Car(
            alwaysMovingStrategy()
        )
    }

    fun alwaysMovingStrategy() = object : MovingStrategy {
        override fun movable(): Boolean {
            return true
        }
    }

    fun canNotMovingStrategy() = object : MovingStrategy {
        override fun movable(): Boolean {
            return false
        }
    }
}
