package calculator.util

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class StringExtensionsKtTest : FunSpec({
    context("문자열이 숫자로만 이루어져 있다면 성공한다.") {
        withData(
            nameFn = { it },
            ts = listOf("1234", "42314", "123415")
        ) { s ->
            s.isNumeric() shouldBe true
        }
    }

    context("문자열이 숫자로만 이루어져 있지 않다면 실패한다.") {
        withData(
            nameFn = { it },
            ts = listOf("-", "+", "/", "*")
        ) { s ->
            s.isNumeric() shouldBe false
        }
    }
})
