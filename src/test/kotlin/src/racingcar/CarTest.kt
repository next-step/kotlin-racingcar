package src.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import src.racingcar.domain.Car

class CarTest {

    @Test
    fun `랜덤 값이 4 이상이면 차가 움직인다`() {
        val moveCount = Car("testName").move(4)
        assertThat(moveCount).isEqualTo(1)
    }

    @Test
    fun `랜덤 값이 4 미만이면 차가 움직이지 않는다`() {
        val moveCount = Car("testName").move(3)
        assertThat(moveCount).isEqualTo(0)
    }

    @Test
    fun `차의 이름을 지정할 수 있다`() {
        val car = Car("testName")
        assertThat(car.name).isEqualTo("testName")
    }
}
