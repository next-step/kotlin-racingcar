package caculator

import calculator.Scanner
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream

class ScannerTest : StringSpec({
    "사용자로부터 입력 값을 받아 문자열로 반환한다" {
        val input = "Hello World!"
        val inputStream = input.byteInputStream()
        System.setIn(inputStream)

        val result = Scanner.scanInput()

        result shouldBe input
    }

    "입력 값이 없는 경우 null이 반환된다" {
        System.setIn(ByteArrayInputStream.nullInputStream())

        val result = Scanner.scanInput()

        result.shouldBeNull()
    }
})
