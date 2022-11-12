package racingcar.extension

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringExtensionsTest: FunSpec ({
    context("공백을 전부 제거한다.") {
        withData(
            nameFn = { it },
            ts = listOf("Sang Hyun", "Sang    Hy  un", "S   a   n    g Hyun", "Sang H   yu   n")
        ) { s ->
            val result = s.removeWhitespaces()
            result shouldBe "SangHyun"
        }
    }
})