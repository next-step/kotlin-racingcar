package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarsTest {

    @Test
    fun `자동차 수가 똑같은지 확인한다`() {
        assertThat(Cars(listOf("flamm", "형준", "야호")).result().size).isEqualTo(3)
    }

    @Test
    fun `모든 차가 자동차 룰에 맞추어 움직이는지 테스트`() {
        val cars = Cars(listOf("flamm", "형준", "야호"))
        cars.move { 4 }
        cars.result().forEach {
            assertThat(it.second).isEqualTo(1)
        }
    }

    @Test
    fun `우승자가 중복되는지 테스트`() {
        val cars = Cars(listOf("flamm", "형준", "야호"))
        cars.move { 4 }
        assertThat(cars.victoryPlayer().isNotEmpty())
    }

    @Test
    fun `우승자가 없으면 0명인지 테스트`() {
        val cars = Cars(listOf("flamm", "형준", "야호"))
        cars.move { 3 }
        assertThat(cars.victoryPlayer().isEmpty())
    }
}

