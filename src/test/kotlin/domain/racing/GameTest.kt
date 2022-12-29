package domain.racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import util.racing.generator.NumberGenerator

class GameTest {

    @Test
    fun `차 갯수가 1개 미만이면 에러가 발생한다`() {
        Assertions.assertThatThrownBy { Game(0, 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("차 갯수는 1개 이상이여야 합니다.")
    }

    @Test
    fun `시도 횟수가 1개 미만이면 에러가 발생한다`() {
        Assertions.assertThatThrownBy { Game(1, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("시도 횟수는 1번 이상이여야 합니다.")
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `4이상이면 차들이 움직인다`(moveNumber: Int) {
        val game = Game(3, 1)

        game.run(object : NumberGenerator {
            override fun generate(): Int {
                return moveNumber
            }
        })

        val result = game.results

        result.forEach {
            it.values.forEach { Assertions.assertThat(it).isEqualTo("-") }
        }
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `4미만이면 차들이 안움직인다`(moveNumber: Int) {
        val game = Game(3, 1)

        game.run(object : NumberGenerator {
            override fun generate(): Int {
                return moveNumber
            }
        })

        val result = game.results

        result.forEach {
            it.values.forEach { Assertions.assertThat(it).isEqualTo("") }
        }
    }
}
