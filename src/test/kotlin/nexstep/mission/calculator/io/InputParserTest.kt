package nexstep.mission.calculator.io

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainInOrder

class InputParserTest : FunSpec({

    test("입력으로 들어온 문자열을 문자열 리스트로 변환한다.") {
        val input = "2 + 4 * 10 / 3"
        InputParser.parse(input) shouldContainInOrder listOf("2", "+", "4", "*", "10", "/", "3")
    }
})
