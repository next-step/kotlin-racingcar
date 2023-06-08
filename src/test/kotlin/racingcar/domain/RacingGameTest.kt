package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `자동차 대수가 1보다 작으면 예외가 발생한다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            RacingGame(attemptCount = 0, cars = listOf(Car()))
        }
        exception.message shouldBe "게임 생성에 필요한 자동차는 1대 이상이어야 한다."
    }
}
