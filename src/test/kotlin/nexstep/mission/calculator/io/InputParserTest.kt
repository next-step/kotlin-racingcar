package nexstep.mission.calculator.io

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe

class InputParserTest : FunSpec({

    test("입력으로 들어온 문자열을 문자열 리스트로 변환한다.") {
        val input = "2 + 4 * 10 / 3"
        InputParser.parse(input) shouldContainInOrder listOf("2", "+", "4", "*", "10", "/", "3")
    }

    test("입력으로 들어온 문자열이 비어있으면 예외를 던진다.") {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            InputParser.parse("")
        }
        exception.message shouldBe "입력값을 제대로 입력해주세요."
    }
})
