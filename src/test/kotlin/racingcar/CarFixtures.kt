package racingcar

object CarFixtures {
    fun createAlwaysMovingCar(): Car {
        return Car(
            "",
            alwaysMovingStrategy()
        )
    }

    private fun alwaysMovingStrategy() = object : MovingStrategy {
        override fun movable(): Boolean {
            return true
        }
    }

    fun createCanNotMovingCar(): Car {
        return Car(
            "",
            canNotMovingStrategy()
        )
    }

    private fun canNotMovingStrategy() = object : MovingStrategy {
        override fun movable(): Boolean {
            return false
        }
    }
}
