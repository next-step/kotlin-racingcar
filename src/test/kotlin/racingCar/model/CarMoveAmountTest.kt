package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMoveAmountTest {

    @Test
    fun `4 이상이면 1을 반환한다`() {
        // given
        val carMoveAmount = CarMoveAmount(5)

        // when
        val amount = carMoveAmount.amount()

        // then
        assertThat(amount).isEqualTo(1)
    }

    @Test
    fun `4 미만이면 0을 반환한다`() {
        // given
        val carMoveAmount = CarMoveAmount(3)

        // when
        val amount = carMoveAmount.amount()

        // then
        assertThat(amount).isEqualTo(0)
    }
}
