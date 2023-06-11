package next.step.racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import next.step.racing.service.to.StepCount

class StepCountTest : DescribeSpec({

    describe("StepCount 생성") {
        context("문자열로 입력 숫자 생성 시") {
            it("성공") {
                StepCount.from("123") shouldBe StepCount(123)
            }
        }

        context("공백으로 입력 숫자 생성 시") {
            it("예외 발생 ") {
                this@context.withData(
                    nameFn = { "\"${it}\"" },
                    listOf("", " ", "      ")
                ) { spaces ->
                    shouldThrow<IllegalArgumentException> {
                        StepCount.from(spaces)
                    }
                }
            }
        }

        context("공백이 아니면서 숫자가 아닌 문자열로 입력 숫자 생성 시") {
            it("예외 발생") {
                this@context.withData(
                    nameFn = { "\"${it}\"" },
                    "dfd", "한글", "+"
                ) { notNumber ->
                    shouldThrow<IllegalArgumentException> {
                        StepCount.from(notNumber)
                    }
                }
            }
        }

        context("양수가 아닌 입력 숫자 생성시") {
            it(" 예외 발생") {
                this@context.withData(
                    nameFn = { "\"${it}\"" },
                    listOf("-100", "-10", "0")
                ) { spaces ->
                    shouldThrow<IllegalArgumentException> {
                        StepCount.from(spaces)
                    }
                }
            }
        }
    }
})
