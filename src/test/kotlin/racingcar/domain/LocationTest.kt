package racingcar.domain

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class LocationTest : DescribeSpec({

    describe("init") {
        context("0 미만 값으로 위치를 생성할 경우") {
            it("예외가 발생한다") {
                listOf(-1, -30).forAll {
                    val exception = shouldThrow<IllegalArgumentException> {
                        Location(it)
                    }
                    exception.message shouldContain "자동차의 위치는 0 미만일 수 없습니다."
                }
            }
        }
    }

    describe("forward") {
        context("0인 위치에서 전진하면") {
            it("1의 위치가 된다") {
                val location = Location(0).forward()
                location.value shouldBe 1
            }
        }
    }

    describe("compareTo") {
        context("두 Location 이 같은 위치 값을 가지면") {
            it("0을 반환한다") {
                Location(1).compareTo(Location(1)) shouldBe 0
            }
        }

        context("다른 Location 보다 큰 값을 가지면") {
            it("1을 반환한다") {
                Location(2).compareTo(Location(1)) shouldBe 1
            }
        }
        context("다른 Location 보다 작은 값을 가지면") {
            it("-1을 반환한다") {
                Location(0).compareTo(Location(1)) shouldBe -1
            }
        }
    }

    describe("equals") {
        context("두 Location 이 같은 위치 값을 가지면") {
            it("동등성을 만족한다") {
                assertSoftly {
                    Location(0) shouldBe Location(0)
                    Location(10) shouldBe Location(10)
                    Location(99) shouldBe Location(99)
                }
            }
        }
    }
})
