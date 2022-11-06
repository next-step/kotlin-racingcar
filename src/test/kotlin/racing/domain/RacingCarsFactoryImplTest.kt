package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingCarsFactoryImplTest {

    lateinit var racingCarsFactory: RacingCarsFactory

    @BeforeEach
    fun setUp() {
        racingCarsFactory = RacingCarsFactoryImpl()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `경주용 자동차가 0개 이상 필요하여 생성해야 되는 경우`(count: Int) {
        val cars = racingCarsFactory.createCars(count)
        assertThat(cars.size).isEqualTo(count)
    }
}
