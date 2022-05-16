package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.domain.CarFactory

class CarFactoryTest {

    @Test
    fun `차 이름이 입력되면, 해당 이름을 가진 차량을 리턴한다`() {
        val names = listOf("Andy", "Bruce")

        val racingCars = CarFactory().createCars(names)

        names.forEachIndexed { index, name ->
            Assertions.assertThat(racingCars[index].name).isEqualTo(name)
        }
    }
}
