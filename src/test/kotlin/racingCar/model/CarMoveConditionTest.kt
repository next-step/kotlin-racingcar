package racingCar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarMoveConditionTest {

    @Test
    fun `4 이상이면 참을 반환한다`() {
        // given
        val carMoveCondition = CarMoveCondition(5)

        // when
        val condition = carMoveCondition.isValid()

        // then
        Assertions.assertThat(condition).isEqualTo(true)
    }

    @Test
    fun `4 미만이면 거짓을 반환한다`() {
        // given
        val carMoveCondition = CarMoveCondition(3)

        // when
        val condition = carMoveCondition.isValid()

        // then
        Assertions.assertThat(condition).isEqualTo(false)
    }
}
