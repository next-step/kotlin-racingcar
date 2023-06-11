package next.step.racing.domain.car

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CarPositionTest : DescribeSpec({

    describe("CarPosition method") {
        context("move") {
            data class MoveExpected(val init: Int, val dx: Int, val expected: Int)

            it("변화량만큼 이동된 위치 제공") {
                this@context.withData(
                    MoveExpected(0, 10, 10),
                    MoveExpected(0, 0, 0),
                    MoveExpected(0, -10, -10),
                    MoveExpected(10, 10, 20),
                ) { (init, dx, expected) ->
                    CarPosition(init).move(dx) shouldBe CarPosition(expected)
                }
            }
        }
    }
})
