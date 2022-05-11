package racingcar.domain

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain

class CarNameTest : DescribeSpec({
    describe("new") {
        context("자동차 이름이 주어졌을 때") {
            it("다섯글자 까지 허용한다") {
                assertSoftly {
                    CarName("요한") shouldNotBe null
                    CarName("다섯글자다") shouldNotBe null
                }
            }

            it("5자를 초과하면 예외를 발생한다") {
                val exception = shouldThrow<IllegalArgumentException> {
                    CarName("다섯글자초과")
                }
                exception.message shouldContain ("자동차 이름은 5자를 초과할 수 없습니다")
            }

            it("빈 문자열이면 예외를 발생한다") {
                val exception = shouldThrow<IllegalArgumentException> {
                    CarName("")
                }
                exception.message shouldContain ("자동차 이름은 빈 문자열일 수 없습니다")
            }
        }
    }

    describe("ofList") {
        context("자동차 이름이 여러 개인 문자열이 주어졌을 때") {
            it("쉼표를 기준으로 구분하여 자동차 이름 목록을 생성한다") {
                val carNames = CarName.ofList("pobi,crong,honux", ",")

                carNames shouldContainExactly listOf(
                    CarName("pobi"),
                    CarName("crong"),
                    CarName("honux"),
                )
            }
        }
    }
})
