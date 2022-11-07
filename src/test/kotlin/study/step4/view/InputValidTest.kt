package study.step4.view

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.throwable.shouldHaveMessage
import java.lang.IllegalArgumentException

class InputValidTest : StringSpec({

    "자동차 이름이 null 로 입력하고, 이름 검증을 하면, 에러를 반환한다" {
        shouldThrow<IllegalArgumentException> {
            InputValid.racingCarNameValid(null)
        }.shouldHaveMessage("자동차 이름을 입력해 주세요")
    }

    "자동차 이름이 공백으로 입력시, 이름 검증을 하면, 에러를 반환한다" {
        listOf("", " ", "     ").forAll {
            shouldThrow<IllegalArgumentException> {
                InputValid.racingCarNameValid(it)
            }.shouldHaveMessage("자동차 이름은 공백일 수 없습니다")
        }
    }

    "자동차 이름이 5자를 초과하여 입력하고, 이름 검증을 하면, 에러를 반환한다" {
        listOf("popodd", "po, popodd ", "  po, popodd   ").forAll {
            shouldThrow<IllegalArgumentException> {
                InputValid.racingCarNameValid(it)
            }.shouldHaveMessage("자동차 이름은 5자를 초과할 수 없습니다")
        }
    }
    "자동차 이름의 마지막에 쉽포(,)로 입력하고, 이름 검증을 하면, 에러를 반환한다" {
        listOf("popd,", "popo , ", "  po, poodd  , ").forAll {
            shouldThrow<IllegalArgumentException> {
                InputValid.racingCarNameValid(it)
            }.shouldHaveMessage("마자막 문자는 쉽표(,) 일수 없습니다")
        }
    }
    "자동차 이름의 중복으로 입력하고, 이름 검증을 하면, 에러를 반환한다" {
        listOf("popd,popd", "popo , popo ", "  po, poodd  ,po ").forAll {
            shouldThrow<IllegalArgumentException> {
                InputValid.racingCarNameValid(it)
            }.shouldHaveMessage("중복된 이름을 사용할 수 없습니다")
        }
    }
})
