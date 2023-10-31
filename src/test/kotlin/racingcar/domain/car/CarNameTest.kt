package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CarNameTest : FunSpec({
    test("이름이 생성된다") {
        val name = "test"

        val result = CarName(name)

        result.value shouldBe name
    }

    test("이름이 5글자를 넘으면 이름 생성에 실패한다") {
        val longName = "abcdef"

        shouldThrowExactly<IllegalArgumentException> {
            CarName(longName)
        }
    }
})
