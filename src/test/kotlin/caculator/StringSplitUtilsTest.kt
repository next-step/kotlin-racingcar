package caculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringSplitUtilsTest : FunSpec({
    test("splitNullInputExpectException") {
        val input: String? = null
        val exception = shouldThrow<IllegalArgumentException> {
            StringSplitUtils.split(input)
        }
        exception.message shouldBe "Input cannot be null"
    }
})
