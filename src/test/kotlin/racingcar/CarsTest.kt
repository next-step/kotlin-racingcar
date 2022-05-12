package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun `Cars move 책임 테스트`() {
        val cars = Cars(listOf(Car(), Car(), Car()))

        val movedCars = cars.move(object : MoveStrategy {
            override fun isMove(): Boolean {
                return true
            }
        })

        assertThat(movedCars[0].position).isEqualTo(1)
    }
}
