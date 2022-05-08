package racingcar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly

class CarsTest : DescribeSpec({
    describe("move") {
        context("이동 전략이 true 이면") {
            it("자동차들이 전진한다") {
                val cars = Cars(
                    listOf(
                        Car(Location(1)),
                        Car(Location(2)),
                        Car(Location(3)),
                    )
                )
                cars.move { true }
            }
        }

        context("이동 전략이 false 이면") {
            it("자동차들이 멈춰있는다") {
                val cars = Cars(
                    listOf(
                        Car(Location(1)),
                        Car(Location(2)),
                        Car(Location(3)),
                    )
                )
                cars.move { false }

            }
        }
    }

    describe("location") {
        it("자동차들의 위치 정보를 제공한다") {
            val cars = Cars(
                listOf(
                    Car(Location(1)),
                    Car(Location(2)),
                    Car(Location(3)),
                )
            )

            cars.location() shouldContainExactly listOf(
                Location(1),
                Location(2),
                Location(3),
            )
        }
    }
})
