package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun `요청한 갯수만큼 자동차를 생성한다`() {
        val givenCount = 5

        val actual = Cars.createCars(givenCount)

        assertThat(actual.size()).isEqualTo(givenCount)
    }

    @Test
    fun `자동차 목록을 이동하면 변경된 자동차 목록을 리턴한다`() {
        // given
        val cars = Cars(listOf(Car(), Car()))

        val actual = cars.move()

        assertThat(actual).isNotSameAs(cars)
    }
}
