package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({
    "자동차 경주 게임을 시도횟수만큼 실행한다." {
        // given
        val cars = Cars(
            listOf(
                Car(),
                Car(),
            ),
        )
        val tryNumber = TryNumber(2)
        val racingGame = RacingGame(
            cars = cars,
            tryNumber = tryNumber,
        )

        // when
        val actual = racingGame.play { 4 }

        // then
        actual.size shouldBe 2
        actual[0].value.size shouldBe 2
        actual[1].value.size shouldBe 2
    }
})
