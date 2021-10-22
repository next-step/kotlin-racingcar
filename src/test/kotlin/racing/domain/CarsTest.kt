package racing.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `차량 갯수가 0인 테스트`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Cars.make(listOf(), Pedal(0)) }
            .withMessage("1개 이상 이름이 필요합니다.")
    }

    @Test
    fun `최대 값 테스트`() {
        val cars = Cars.make(carNames = listOf("a", "b", "c"), pedal = Pedal(0))
        val winners = cars.getWinners()

        assertThat(winners.size).isEqualTo(cars.cars.size)
        assertThat(winners).isEqualTo(cars.cars)
    }
}
