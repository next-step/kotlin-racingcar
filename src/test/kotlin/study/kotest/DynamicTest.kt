package study.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength

class DynamicTest : FunSpec({

    listOf(
        "sam",
        "pam",
        "tom"
    ).forEach {
        test("$it 는 세 글자 이름이다"){
            it.shouldHaveLength(3)
        }
    }
})