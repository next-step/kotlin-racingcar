package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class RacingGameTest : StringSpec({
    "레이싱 게임은 매 횟수마다 자동차의 현재 위치를 보여줘요" {
        val mockNumberGenerator = mockk<NumberGenerator>()
        every { mockNumberGenerator.rand() } returns 0

        val racingGame = RacingGame(
            cars = listOf(Car(0, "car")),
            numberGenerator = mockNumberGenerator
        )

        val car = racingGame.round()[0]

        car.location shouldBe 0
    }
})
