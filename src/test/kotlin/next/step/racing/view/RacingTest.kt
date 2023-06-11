package next.step.racing.view

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import next.step.racing.domain.car.CarNames
import next.step.racing.domain.car.CarRecord
import next.step.racing.domain.racing.Racing
import next.step.racing.domain.racing.RacingResult
import next.step.racing.domain.racing.StepCount

class RacingTest : DescribeSpec({

    describe("Racing method") {
        context("race") {
            it("제공된 차의 개수와 횟수만큼 주어진 이동전략을 통해 경주를 하고 전체 차의 위치정보를 제공한다") {
                Racing.race(CarNames.from("GV1,GV3,GV5"), StepCount(5)) { 1 } shouldBe RacingResult(
                    listOf(
                        listOf(CarRecord("GV1", 1), CarRecord("GV3", 1), CarRecord("GV5", 1)),
                        listOf(CarRecord("GV1", 2), CarRecord("GV3", 2), CarRecord("GV5", 2)),
                        listOf(CarRecord("GV1", 3), CarRecord("GV3", 3), CarRecord("GV5", 3)),
                        listOf(CarRecord("GV1", 4), CarRecord("GV3", 4), CarRecord("GV5", 4)),
                        listOf(CarRecord("GV1", 5), CarRecord("GV3", 5), CarRecord("GV5", 5)),
                    ),
                    listOf("GV1", "GV3", "GV5")
                )
            }
        }
    }
})
