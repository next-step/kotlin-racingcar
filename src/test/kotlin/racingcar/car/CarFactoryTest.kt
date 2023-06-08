package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4])
    fun `차 생성 테스트`(carsCnt: Int) {
        val cars = CarFactory.getCars(carsCnt)
        Assertions.assertThat(cars.size).isEqualTo(carsCnt)
    }
}
