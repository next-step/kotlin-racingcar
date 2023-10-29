package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차의 초기 위치는 0이다`() {
        val car = Car()

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `MoveCondition의 canForward 조건이 참이면 차가 움직일 수 있다`() {
        val car = Car()
        val moveCondition = OnlyTrueMoveCondition()

        car.tryMove(moveCondition)

        assertThat((car.position)).isEqualTo(1)
    }

    @Test
    fun `MoveCondition의 canForward 조건이 거짓이면 차가 움직일 수 있다`() {
        val car = Car()
        val moveCondition = OnlyFalseMoveCondition()

        car.tryMove(moveCondition)

        assertThat((car.position)).isEqualTo(0)
    }
}
