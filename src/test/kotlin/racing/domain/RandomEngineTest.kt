package racing.domain

import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class RandomEngineTest {

    @Test
    fun `동작 테스트, move와 stop의 비율이 대략 6대4인지 확인할 수 있다`() {
        (0 until 10000).map { RandomEngine.canMove() }
            .partition { it }
            .let { "move: ${it.first.count()}, stop: ${it.second.count()}" }
            .let(::println)
    }
}
