package domain.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarKoTest : DescribeSpec({
    describe("method test") {
        context("run test") {
            listOf(4, 5, 6, 7, 8, 9).forEach {
                it("4이상이면 차들이 움직인다") {
                    val car = Car(Name("marco"))

                    car.move(it)
                    car.getPosition() shouldBe 1
                }
            }

            listOf(0, 1, 2, 3).forEach {
                val car = Car(Name("marco"))

                car.move(it)
                car.getPosition() shouldBe 0
            }
        }
    }
})
