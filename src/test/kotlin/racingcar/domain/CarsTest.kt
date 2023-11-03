package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차 이름들로 자동차들을 생성한다`() {
        val input = listOf("일", "이", "삼", "사", "오")
        val carNames = CarNames(input)
        val cars = Cars.createTo(carNames)

        assertThat(cars.size).isEqualTo(carNames.size)
    }
}
