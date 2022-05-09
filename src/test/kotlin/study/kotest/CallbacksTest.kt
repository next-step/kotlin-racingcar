package study.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength

class CallbacksTest : FunSpec({

    beforeEach {
        println("Hello from $it")
    }

    test("sam 은 세 글자 이름이다") {
        "sam".shouldHaveLength(3)
    }

    afterEach {
        println("Goodbye from $it")
    }
})
