package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsFactoryTest {

    @Test
    fun `Cars 생성에 성공한다`() {
        val carNames = listOf(CarName("bear1"), CarName("bear2"))
        val cars = CarsFactory.createCars(TrueEngineCarCreator(), carNames)

        assertThat(cars.cars.size).isEqualTo(carNames.size)
    }
}
