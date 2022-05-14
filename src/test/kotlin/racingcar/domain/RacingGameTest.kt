package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({
    "자동차 경주 게임 객체를 생성한다" {
        // given
        val cars = listOf(Car(), Car())
        val tryNumber = TryNumber(2)

        // when // then
        shouldNotThrowAny {
            RacingGame(
                cars = cars,
                tryNumber = tryNumber,
            )
        }
    }

    "자동차가 2대 미만일 때, 자동차 경주 게임을 생성하면 예외를 발생시킨다." {
        // given
        val cars = listOf(Car())
        val tryNumber = TryNumber(2)

        // when // then
        shouldThrowExactly<IllegalArgumentException> {
            RacingGame(
                cars = cars,
                tryNumber = tryNumber,
            )
        }
    }

    "자동차 경주 게임을 시도횟수만큼 실행한다." {
        // given
        val cars = listOf(Car(), Car())
        val tryNumber = TryNumber(2)
        val racingGame = RacingGame(
            cars = cars,
            tryNumber = tryNumber,
        )

        // when
        val actual = racingGame.play { 4 }

        // then
        actual.size shouldBe 2
        actual[0].size shouldBe 2
        actual[1].size shouldBe 2
    }
})
