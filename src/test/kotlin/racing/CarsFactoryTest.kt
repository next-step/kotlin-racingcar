package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class CarsFactoryTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 10])
    fun `갯수만큼 car를 생성한다`(count: Int) {
        val cars = CarsFactory.getCars(CarCount(count))

        assertThat(cars.cars.count()).isEqualTo(count)
    }
}
