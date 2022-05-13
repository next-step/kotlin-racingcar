package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

internal class RacingTest {

    @Test
    fun `레이싱 컬렉션 사이즈`() {
        val racing = Racing(Cars(listOf(Car(), Car())))

        val strategy = object : MoveStrategy {
            override fun isMove(): Boolean {
                return true
            }
        }

        racing.start(1, strategy)
        assertThat(racing.result).size().isEqualTo(1)
    }

    @Test
    fun `결과 값 테스트`() {
        val racing = Racing(Cars(listOf(Car(), Car())))

        val strategy = object : MoveStrategy {
            override fun isMove(): Boolean {
                return true
            }
        }

        racing.start(1, strategy)

        assertAll("", {
            assertThat(racing.result[0].cars[0].position).isEqualTo(1)
            assertThat(racing.result[0].cars[1].position).isEqualTo(1)
        })
    }

    @Test
    fun `잘못된 결과 값 테스트`() {
        val racing = Racing(Cars(listOf(Car(), Car())))

        val strategy = object : MoveStrategy {
            override fun isMove(): Boolean {
                return true
            }
        }

        racing.start(1, strategy)
        assertThrows<IndexOutOfBoundsException> { racing.result[1].cars[0].position }
    }
}
