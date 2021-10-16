package racingCar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarsTest {
    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5])
    fun `자동차 수가 똑같은지 확인한다`(input: Int) {
        Assertions.assertThat(Cars(input).mileageOfCars().size).isEqualTo(input)
    }
}
