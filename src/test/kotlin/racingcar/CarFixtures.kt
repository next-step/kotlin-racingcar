package racingcar

import java.util.UUID

object CarFixtures {
    fun createAlwaysMovingCar(): Car {
        return Car(
            UUID.randomUUID().toString(),
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
            UUID.randomUUID().toString(),
            canNotMovingStrategy()
        )
    }

    private fun canNotMovingStrategy() = object : MovingStrategy {
        override fun movable(): Boolean {
            return false
        }
    }
}
