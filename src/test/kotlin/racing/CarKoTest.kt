package racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarKoTest : DescribeSpec({
    describe("move method") {
        val moveThreshold = 10

        forAll(
            row(moveThreshold),
            row(moveThreshold + 4),
            row(moveThreshold + 10)
        ) { power ->
            context("with power : $power") {
                val car = Car(moveThreshold = moveThreshold)
                car.move(power)
                it("move forward when power greater or equals than threshold") {
                    car.position shouldBe 1
                }
            }
        }

        forAll(
            row(moveThreshold - 1),
            row(moveThreshold - 4),
        ) { power ->
            context("with power : $power") {
                val car = Car(moveThreshold = moveThreshold)
                car.move(power)
                it("can't move when power less than threshold") {
                    car.position shouldBe 0
                }
            }
        }
    }
})
