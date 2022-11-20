package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class CarNameTest : FunSpec({
    context("자동차 이름 생성 테스트") {
        context("5 글자 이하의 이름이면") {
            test("자동차 이름을 생성할 수 있다.") {
                val carName = CarName(value = "동구")
                carName.value shouldBe "동구"
            }
        }

        context("5 글자 초과의 이름이면") {
            test("IllegalStateException 이 발생한다.") {
                val exception = assertThrows<IllegalStateException> { CarName(value = "relkimm") }
                exception.message shouldBe "자동차 이름은 5 글자를 초과할 수 없습니다."
            }
        }
    }
})
