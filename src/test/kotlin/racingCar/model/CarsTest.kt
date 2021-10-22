package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차 수가 똑같은지 확인한다`() {
        // given
        val cars = Cars(listOf("flamm", "형준", "야호"))

        // when
        val sizeOfCars = cars.result().size

        // then
        assertThat(sizeOfCars).isEqualTo(3)
    }

    @Test
    fun `우승자가 중복되는지 테스트`() {
        // given
        val cars = Cars(listOf("flamm", "형준", "야호"))

        // when
        cars.move()
        val victoryPlayer = cars.victoryPlayer()

        // then
        assertThat(victoryPlayer.isNotEmpty())
    }

    @Test
    fun `우승자가 없으면 0명인지 테스트`() {
        // given
        val cars = Cars(listOf("flamm", "형준", "야호"))

        // when
        cars.move()
        val victoryPlayer = cars.victoryPlayer()

        // then
        assertThat(victoryPlayer.isEmpty())
    }
}
