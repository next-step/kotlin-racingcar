package next.step.racing.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec

class CarNameTest : DescribeSpec({

    describe("CarName 생성") {
        context("차 이름이 공백이면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> { CarName("") }
            }
        }

        context("차 이름이 비어있으면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> { CarName(" ") }
            }
        }

        context("차 이름이 5자 초과이면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> { CarName("abcdef") }
            }
        }
    }
})
