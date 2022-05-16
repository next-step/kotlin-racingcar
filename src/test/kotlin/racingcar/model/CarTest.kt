package racingcar.model

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private val defaultCarPosition = 0
    private val validCarName = "myCar"

    @Test
    fun `무작위 값이 4보다 낮을 경우 차는 움직이지 않는다`() {
        val noMovingStrategy = object : MovingStrategy {
            override fun tryMove(): Boolean = false
        }

        val car = Car(validCarName, movingStrategy = noMovingStrategy)
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

        val car = Car(validCarName, movingStrategy = forwardMovingStrategy)
        val positionBeforeFirstTry = car.position
        car.move()
        val positionAfterFirstTry = car.position

        assertEquals(defaultCarPosition, positionBeforeFirstTry)
        assertEquals(defaultCarPosition + 1, positionAfterFirstTry)
    }

    @Test
    fun `자동차 이름 - 빈 값일 경우 에러가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy { Car("") }
            .withMessage("자동차의 이름은 빈 값이거나 5자가 넘어가면 안됩니다")
    }

    @Test
    fun `자동차 이름 - 5자가 넘어갈 경우 에러가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy { Car("666666") }
            .withMessage("자동차의 이름은 빈 값이거나 5자가 넘어가면 안됩니다")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "22", "333", "4444", "55555"])
    fun `자동차 이름의 길이가 1과 5사이라면 해당 이름을 가진 Car 인스턴스가 생성된다`(input: String) {
        val car = Car(input)
        assertEquals(input, car.name)
    }
}
