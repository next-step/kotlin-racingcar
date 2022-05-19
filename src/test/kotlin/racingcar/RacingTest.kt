package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.MoveStrategy

internal class RacingTest {

    @Test
    fun `레이싱 컬렉션 사이즈`() {
        val racing = Racing(Cars(listOf(Car("a"), Car("b"))))

        val strategy = MoveStrategy { true }

        racing.start(1, strategy)
        assertThat(racing.history).size().isEqualTo(1)
    }

    @Test
    fun `결과 값 테스트`() {
        val racing = Racing(Cars(listOf(Car("a"), Car("b"))))

        val strategy = MoveStrategy { true }

        racing.start(1, strategy)

        assertAll("자동차 포지션 테스트", {
            assertThat(racing.history[0].cars[0].position).isEqualTo(1)
            assertThat(racing.history[0].cars[1].position).isEqualTo(1)
        })
    }

    @Test
    fun `잘못된 결과 값 테스트`() {
        val racing = Racing(Cars(listOf(Car("a"), Car("b"))))

        val strategy = object : MoveStrategy {
            override fun isMove(): Boolean {
                return true
            }
        }

        racing.start(1, strategy)
        assertThrows<IndexOutOfBoundsException> { racing.history[1].cars[0].position }
    }
}
