package racingcar.domain.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarFactoryTest {
    @Test
    fun `차 생성 테스트`() {
        // given
        val carNames = listOf("pobi", "crong", "honux")

        val cars = CarFactory.getCars(carNames)
        Assertions.assertThat(cars.size).isEqualTo(3)
    }
}
