package nexstep.mission.racingcar.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class NameTest : FunSpec({

    context("Name 객체를 생성할 때") {
        test("5자를 초과하지 않으면 정상 생성한다.") {
            shouldNotThrowAny {
                Name("12345")
            }
        }

        test("5자를 초과하면 예외가 발생한다.") {
            val exception = shouldThrowExactly<IllegalArgumentException> {
                Name("123456")
            }
            exception.message shouldBe "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }
})
