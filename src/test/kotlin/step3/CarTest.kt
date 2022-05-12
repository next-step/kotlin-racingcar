package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `1) 이동 성공`() {
        val car: Car = Car.instance
        car.move(object : MovingStrategy {
            override fun movable(): Boolean {
                return true
            }
        })
        Assertions.assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `2) 이동 실패`() {
        val car: Car = Car.instance
        car.move(object : MovingStrategy {
            override fun movable(): Boolean {
                return false
            }
        })
        Assertions.assertThat(car.position).isEqualTo(0)
    }
}
