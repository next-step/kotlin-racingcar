package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `시도 횟수가 1보다 작으면 예외가 발생한다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            RacingGame(attemptCount = 0, cars = listOf(Car()))
        }
        exception.message shouldBe "게임 생성에 필요한 시도 횟수는 1회 이상이어야 한다."
    }

    @Test
    fun `자동차 대수가 1보다 작으면 예외가 발생한다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            RacingGame(attemptCount = 1, cars = listOf())
        }
        exception.message shouldBe "게임 생성에 필요한 자동차 대수는 1대 이상이어야 한다."
    }

    @Test
    fun `게임을 생성할 수 있다`() {
        val actual = RacingGame(attemptCount = 1, cars = listOf(Car()))

        actual.attemptCount shouldBe 1
        actual.cars shouldHaveSize 1
    }
}
