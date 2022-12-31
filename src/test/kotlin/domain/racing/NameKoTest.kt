package domain.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.throwable.shouldHaveMessage

class NameKoTest : DescribeSpec({
    describe("validate") {
        context("validateName") {
            listOf("", "  ").forEach {
                it("자동차 이름은 빈값일 수 없다") {
                    val message = shouldThrow<java.lang.IllegalArgumentException> { Name(it) }

                    message shouldHaveMessage "자동차 이름은 빈값일 수 없습니다."
                }
            }

            listOf("123456", "1234567").forEach {
                it("자동차 이름은 빈값일 수 없다") {
                    val message = shouldThrow<java.lang.IllegalArgumentException> { Name(it) }

                    message shouldHaveMessage "자동차 이름은 5자를 초과할 수 없습니다."
                }
            }
        }
    }
})
