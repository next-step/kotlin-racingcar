package study.step4.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import java.lang.IllegalArgumentException

class RacingCarNameValidTest : StringSpec({

    "자동차 이름이 5자를 초과하여 입력하고, 이름 검증을 하면, 에러를 반환한다" {
        listOf("popodd", "po, popodd ", "  po, popodd   ").forAll {
            shouldThrow<IllegalArgumentException> {
                RacingGame(racingCarNames = it, repeatNumber = 3)
            }.shouldHaveMessage("자동차 이름은 5자를 초과할 수 없습니다")
        }
    }
    "자동차 이름의 마지막에 쉽포(,)로 입력하고, 이름 검증을 하면, 이를 제외하고 리스트를 반환한다" {
        listOf("popd," to 1, "popo , " to 1, "  po, poodd  , " to 2)
            .forAll { (carNames, size) ->
                val racingGame = RacingGame(racingCarNames = carNames, repeatNumber = 3)

                assertThat(racingGame.getCars().size).isEqualTo(size)
            }
    }
    "자동차 이름의 중복으로 입력하고, 이름 검증을 하면, 에러를 반환한다" {
        listOf("popd,popd", "popo , popo ", "  po, poodd  ,po ").forAll {
            shouldThrow<IllegalArgumentException> {
                RacingGame(racingCarNames = it, repeatNumber = 3)
            }.shouldHaveMessage("중복된 이름을 사용할 수 없습니다")
        }
    }
})
