package next.step.racing.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import next.step.racing.domain.car.CarName
import next.step.racing.domain.car.CarNames

class CarNamesTest : DescribeSpec({

    describe("CarNames 생성") {
        context("차이름을 comma와 함께 입력하면") {
            it("comma로 구분") {
                CarNames.from("gv1,gv2") shouldBe CarNames(listOf(CarName("gv1"), CarName("gv2")))
            }
        }
    }
})
