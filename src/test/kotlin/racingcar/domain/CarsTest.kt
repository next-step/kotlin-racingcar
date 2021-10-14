package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarsTest {
    @DisplayName("NumberGenerator 가 4 이상인 숫자를 생성하면, 자동차들이 전진한다.")
    @Test
    fun `전진 가능`() {
        val cars = Cars(carNumber, object : NumberGenerator {
            override fun getNumber() = 5
        })
        repeat(moveNumber) { cars.move() }
        assertThat(cars.exportPositions())
            .isEqualTo(List(carNumber) { moveNumber })
    }

    @DisplayName("NumberGenerator 가 4 미만인 숫자를 생성하면, 자동차들이 전진하지 않는다.")
    @Test
    fun `전진 불가능`() {
        val cars = Cars(carNumber, object : NumberGenerator {
            override fun getNumber() = 3
        })
        repeat(moveNumber) { cars.move() }
        assertThat(cars.exportPositions())
            .isEqualTo(List(carNumber) { DEFAULT_POSITION })
    }

    companion object {
        private const val carNumber = 3
        private const val moveNumber = 5
        private const val DEFAULT_POSITION = 0
    }
}
