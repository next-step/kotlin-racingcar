package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.TestNumberGenerator

class CarsTest {
    @Test
    fun `자동차들을 생성한다`() {
        val cars = Cars.from("pobi,crong,honux")
        assertThat(cars).isNotNull()
    }

    @Test
    fun `자동차 경주 시 4이상의 숫자는 전진한다`() {
        val cars = Cars.from("pobi,crong,honux")

        cars.race(TestNumberGenerator(4))

        assertThat(cars.positions()).isEqualTo(listOf(Position(1), Position(1), Position(1)))
    }

    @Test
    fun `자동차 경주 시작 시 4미만의 숫자는 멈춰 있는다`() {
        val cars = Cars.from("pobi,crong,honux")

        cars.race(TestNumberGenerator(3))

        assertThat(cars.positions()).isEqualTo(listOf(Position(0), Position(0), Position(0)))
    }
}
