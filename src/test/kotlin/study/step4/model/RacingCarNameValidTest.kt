package study.step4.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.throwable.shouldHaveMessage

class RacingCarNameValidTest : StringSpec({

    "자동차 이름이 5자를 초과하여 입력하고, 이름 검증을 하면, 에러를 반환한다" {
        listOf(
            listOf("popodd"),
            listOf("po", "popodd"),
            listOf("po", "popodd")
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                RacingGame(racingCarNames = it, repeatNumber = 3)
            }.shouldHaveMessage("자동차 이름은 5자를 초과할 수 없습니다")
        }
    }

    "자동차 이름의 중복으로 입력하고, 이름 검증을 하면, 에러를 반환한다" {
        listOf(
            listOf("popd", "popd"),
            listOf("po", "po"),
            listOf("po", "ppodd", "po")
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                RacingGame(racingCarNames = it, repeatNumber = 3)
            }.shouldHaveMessage("중복된 이름을 사용할 수 없습니다")
        }
    }

    "주어진 레이싱 경기에, 참가하는 자동차 수가 0이면, 에러를 발생한다" {
        shouldThrow<IllegalArgumentException> {
            // expect
            RacingGame(listOf(""), 3, RandomDigit())
        }.shouldHaveMessage("자동차 이름은 빈값을 입력 할 수  없습니다")
    }
})
