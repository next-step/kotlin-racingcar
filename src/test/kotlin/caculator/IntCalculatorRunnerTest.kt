package caculator

import calculator.IntCalculatorRunner
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.system.captureStandardOut
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.lang.IllegalArgumentException

class IntCalculatorRunnerTest : StringSpec({
    "계산기가 실행된다" {
        val input = "1 + 3 * 5 - 5 / 3"
        System.setIn(input.byteInputStream())

        val output = captureStandardOut {
            IntCalculatorRunner.run()
        }

        output shouldBe "5\n"
    }

    "입력 값이 없는 경우 계산기 실행에 실패한다" {
        System.setIn(ByteArrayInputStream.nullInputStream())

        shouldThrowExactly<IllegalArgumentException> {
            IntCalculatorRunner.run()
        }
    }
})
