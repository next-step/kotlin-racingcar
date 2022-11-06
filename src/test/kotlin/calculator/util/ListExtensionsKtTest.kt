package calculator.util

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class ListExtensionsKtTest : FunSpec({
    context("리스트의 사이즈가 홀수인지 확인한다.") {
        withData(
            nameFn = { it.toString() },
            ts = listOf(
                listOf("1", "2", "3"),
                listOf("4", "5", "6", "7", "8")
            )
        ) { list ->
            list.isOddSize() shouldBe true
        }
    }

    context("리스트의 사이즈가 짝수인지 확인한다..") {
        withData(
            nameFn = { it.toString() },
            ts = listOf(
                listOf("1", "2"),
                listOf("3", "4", "5", "6")
            )
        ) { list ->
            list.isOddSize() shouldBe false
        }
    }
})
