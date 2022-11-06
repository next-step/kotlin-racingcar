package calculator.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class ExpressionExtensionTest : FunSpec({
    context("입력된 값을 \" \"로 split 한다.(성공)") {
        withData(
            "2 + 3 + 10 + 11" to listOf("2", "+", "3", "+", "10", "+", "11"),
            "2.2 + 3 - 10.3 + 11" to listOf("2.2", "+", "3", "-", "10.3", "+", "11"),
            "9 - 0 + 1 + 100.1" to listOf("9", "-", "0", "+", "1", "+", "100.1"),
            "9 - 0 + 1 + 100.1" to listOf("9", "-", "0", "+", "1", "+", "100.1"),
            "9-0+1+100.1" to listOf("9-0+1+100.1"),
        ) { (data, result) ->
            data.rawExpressionSplit() shouldBe result
        }
    }
})
