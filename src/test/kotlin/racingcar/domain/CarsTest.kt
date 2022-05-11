package racingcar.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarsTest : DescribeSpec({

    describe("move") {
        context("이동 전략이 true 이면") {
            it("자동차들이 전진한다") {
                val car1 = Car(location = Location(1))
                val car2 = Car(location = Location(2))
                val car3 = Car(location = Location(3))
                val cars = Cars(
                    listOf(car1, car2, car3)
                )

                cars.move { true }

                assertSoftly {
                    car1.location shouldBe Location(2)
                    car2.location shouldBe Location(3)
                    car3.location shouldBe Location(4)
                }
            }
        }

        context("이동 전략이 false 이면") {
            it("자동차들이 멈춰있는다") {
                val car1 = Car(location = Location(1))
                val car2 = Car(location = Location(2))
                val car3 = Car(location = Location(3))
                val cars = Cars(
                    listOf(car1, car2, car3)
                )

                cars.move { false }

                assertSoftly {
                    car1.location shouldBe Location(1)
                    car2.location shouldBe Location(2)
                    car3.location shouldBe Location(3)
                }
            }
        }
    }

    describe("nameWithLocation") {
        it("자동차 이름과 위치 정보를 조회한다") {
            val cars = Cars(
                listOf(
                    Car(CarName("car1"), Location(1)),
                    Car(CarName("car2"), Location(2)),
                    Car(CarName("car3"), Location(3)),
                )
            )

            cars.nameWithLocation() shouldBe listOf(
                CarName("car1") to Location(1),
                CarName("car2") to Location(2),
                CarName("car3") to Location(3),
            )
        }
    }

    describe("size") {
        it("자동차들의 수를 반환한다") {
            val cars = Cars(
                listOf(
                    Car(location = Location(1)),
                    Car(location = Location(2)),
                    Car(location = Location(3)),
                )
            )

            cars.size() shouldBe 3
        }
    }

    describe("of") {
        context("자동차들의 수를 입력받아 자동차들을 만든다") {
            val cars = Cars.of(5)

            cars.size() shouldBe 5
        }
    }
})
