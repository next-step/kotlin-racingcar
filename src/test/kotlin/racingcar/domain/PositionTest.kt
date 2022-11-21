package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PositionTest : FunSpec({
    test("현재 위치를 기준으로 앞의 위치를 구할 수 있다.") {
        // given
        val position = Position(value = 3)
        // when
        val actual = position.forward()
        // then
        actual.value shouldBe 4
    }
})
