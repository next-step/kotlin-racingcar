package domain.racing

import io.kotest.core.spec.style.DescribeSpec
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
    }
})
