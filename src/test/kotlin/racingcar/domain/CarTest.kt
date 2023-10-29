package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({

    describe("move") {

        listOf(4, 5, 6, 7, 8, 9).forEach { power ->
            val car = Car()

            context("엔진의 값이 ${power}라면") {
                it("차의 위치는 이동한다") {
                    car.move(power)
                    car.position shouldBe CarPosition(2)
                }
            }
        }

        listOf(0, 1, 2, 3).forEach { power ->
            val car = Car()

            context("엔진의 값이 ${power}라면") {
                it("차의 위치는 이동하지 않는다") {
                    car.move(power)
                    car.position shouldBe CarPosition(1)
                }
            }
        }
    }
})
