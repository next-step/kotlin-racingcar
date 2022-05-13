package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.domain.CarFactory

class CarFactoryTest {

    @Test
    fun `차 이름이 5글자를 초과하면, IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            CarFactory().createCars(listOf("BrunoMars"))
        }
    }

    @Test
    fun `차 이름이 입력되면, 해당 이름을 가진 차량을 리턴한다`() {
        val names = listOf("Andy", "Bruce")

        val racingCars = CarFactory().createCars(names)

        racingCars.cars.forEachIndexed { index, car ->
            Assertions.assertThat(car.name).isEqualTo(names[index])
        }
    }
}
