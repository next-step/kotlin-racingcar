package racingCar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {
    @DisplayName(value = "입력된 자동차 대수 만큼 자동차를 가진 리스트 생성")
    @Test
    fun `create car list`() {
        val cars = Cars(listOf("harry", "van"))
        assertThat(cars.cars.size).isEqualTo(2)
    }
}
