package racingcar.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class StringExtensionTest : FunSpec({
    context("String을 , 로 split 한다.") {
        withData(
            "a,b,c,d" to listOf("a", "b", "c", "d"),
            "ab,bd,cs,da" to listOf("ab", "bd", "cs", "da"),
            "123,2,3,1" to listOf("123", "2", "3", "1"),
        ) { (data, result) ->
            data.splitByComma() shouldBe result
        }
    }

    context("List를 , 로 joing 한다.") {
        withData(
            listOf("a", "b", "c", "d") to "a,b,c,d",
            listOf("aa", "bb", "cc", "dd") to "aa,bb,cc,dd",
            listOf("a1", "b1", "c1", "d1") to "a1,b1,c1,d1",
        ) { (data, result) ->
            data.joinToStringByComma() shouldBe result
        }
    }
})
