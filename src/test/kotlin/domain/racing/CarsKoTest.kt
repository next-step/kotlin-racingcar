package domain.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class CarsKoTest : DescribeSpec({
    describe("method test") {
        context("run test") {
            listOf(4, 5, 6, 7, 8, 9).forEach {
                it("4이상이면 차들이 움직인다") {
                    val cars = Cars.of(listOf(Name("pobi"), Name("jason"), Name("marco")))

                    cars.move { it }

                    val result = cars.toResult()

                    result.values.forEach {
                        it shouldBe "-"
                    }
                }
            }

            listOf(0, 1, 2, 3).forEach {
                it("3미만이면 차들이 움직이지 않는다.") {
                    val cars = Cars.of(listOf(Name("pobi"), Name("jason"), Name("marco")))

                    cars.move { it }

                    val result = cars.toResult()

                    result.values.forEach {
                        it shouldBe ""
                    }
                }
            }
        }

        context("toWinners Test") {
            it("가장 많이 움직인 차로 우승자를 뽑는다") {
                val car1 = Car(Name("pobi"), Position(1))
                val car2 = Car(Name("jason"), Position(2))
                val car3 = Car(Name("marco"), Position(3))
                val cars = Cars(listOf(car1, car2, car3))

                val winners = cars.toWinners()

                winners.winners shouldHaveSize 1
                winners.winners.first().getName() shouldBe "marco"
            }
        }
    }
})
