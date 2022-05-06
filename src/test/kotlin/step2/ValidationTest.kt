package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ValidationTest : DescribeSpec({
    describe("requireNotZero 메소드") {
        context("숫자가 0 인지 검증한다.") {
            it("숫자가 0이면 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    requireNotZero(0)
                }
            }

            it("숫자가 0이 아니면 패스한다.") {
                val result = requireNotZero(1)
                result shouldBe Unit
            }
        }
    }

    describe("checkNotBlank 메소드") {
        context("텍스트를 검증한다.") {
            it("텍스트가 정상이면 반환한다.") {
                val result = checkNotBlank("3+5")
                result shouldBe "3+5"

            }

            it("텍스트가 null 이면 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    checkNotBlank(null)
                }
            }

            it("텍스트가 공벡 이면 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    checkNotBlank(" ")
                }
            }

            it("텍스트가 없으면 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    checkNotBlank("")
                }
            }
        }
    }
})