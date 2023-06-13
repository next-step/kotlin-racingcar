package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    internal fun `MoveStrategy의 값이 true일때는 전진한다`() {
        val car = Car("aaa")
        car.move(object : MoveStrategy {
            override fun move(): Boolean {
                return true
            }
        })
        assertThat(car.score).isEqualTo(1)
    }

    @Test
    internal fun `MoveStrategy의 값이 false때는 전진하지 않는다`() {
        val car = Car("bbb")
        car.move(object : MoveStrategy {
            override fun move(): Boolean {
                return false
            }
        })
        assertThat(car.score).isEqualTo(0)
    }

    @Test
    internal fun `이름이 5글자 이상이면 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("rabbit")
        }
    }
}
