package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `자동차 일급컬랙션을 생성할 수 있다`() {
        assertThat(Cars(3)).isEqualTo(Cars(3))
    }

    @Test
    fun `이동후 위치목록을 제공한다`() {
        val cars = Cars(3)
        cars.drive()
        cars.drive()
        val positions: Positions = cars.positions()
        assertThat(positions).contains(Positions(2, 2))
    }

    class Cars(private val cars: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Cars

            if (cars != other.cars) return false

            return true
        }

        override fun hashCode(): Int {
            return cars
        }
    }
}
