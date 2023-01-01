package domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameTest {

    @Test
    fun `차 갯수가 1개 미만이면 에러가 발생한다`() {
        assertThrows<IllegalArgumentException>("차 갯수는 1개 이상이여야 합니다.") { Game(emptyList(), 1) }
    }

    @Test
    fun `시도 횟수가 1번 미만이면 에러가 발생한다`() {
        val names = listOf(Name("pobi"), Name("jason"), Name("marco"))

        assertThrows<IllegalArgumentException>("시도 횟수는 1번 이상이여야 합니다.") { Game(names, 0) }
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `4이상이면 차들이 움직인다`(moveNumber: Int) {
        val names = listOf(Name("pobi"), Name("jason"), Name("marco"))
        val game = Game(names, 1)

        game.run { moveNumber }

        val result = game.results

        result.forEach {
            it.values.forEach { assertThat(it).isEqualTo("-") }
        }
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `4미만이면 차들이 안움직인다`(moveNumber: Int) {
        val names = listOf(Name("pobi"), Name("jason"), Name("marco"))
        val game = Game(names, 1)

        game.run { moveNumber }

        val result = game.results

        result.forEach {
            it.values.forEach { assertThat(it).isEqualTo("") }
        }
    }
}
