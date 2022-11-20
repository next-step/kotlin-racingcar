package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

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

    "레이싱 게임에 참여하는 자동차는 1대 이상이어야 합니다." {
        assertThrows<IllegalArgumentException> {
            val mockNumberGenerator = mockk<NumberGenerator>()
            every { mockNumberGenerator.rand() } returns 0

            val racingGame = RacingGame(
                cars = listOf(),
                numberGenerator = mockNumberGenerator
            )
        }
    }
})
