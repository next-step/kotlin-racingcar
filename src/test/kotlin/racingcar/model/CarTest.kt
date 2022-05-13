package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    private val defaultCarPosition = 0

    @Test
    fun `무작위 값이 4보다 낮을 경우 차는 움직이지 않는다`() {
        val noMovingStrategy = object : MovingStrategy {
            override fun tryMove(): Boolean = false
        }
        val car = Car(movingStrategy = noMovingStrategy)
        val positionBeforeFirstTry = car.position
        car.move()
        val positionAfterFirstTry = car.position

        assertEquals(defaultCarPosition, positionBeforeFirstTry)
        assertEquals(defaultCarPosition, positionAfterFirstTry)
    }

    @Test
    fun `무작위 값이 4보다 같거나 높을 경우 차는 한 칸 움직인다`() {
        val forwardMovingStrategy = object : MovingStrategy {
            override fun tryMove(): Boolean = true
        }
        val car = Car(movingStrategy = forwardMovingStrategy)
        val positionBeforeFirstTry = car.position
        car.move()
        val positionAfterFirstTry = car.position

        assertEquals(defaultCarPosition, positionBeforeFirstTry)
        assertEquals(defaultCarPosition + 1, positionAfterFirstTry)
    }
}
