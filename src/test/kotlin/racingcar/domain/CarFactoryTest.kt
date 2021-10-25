package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = ["3", "10", "11"])
    fun `입력받은 자동차 개수 만큼 생성이 되는가`(carCount: Int) {
        assertThat(CarFactory().createCars(carCount).size).isEqualTo(carCount)
    }
}
