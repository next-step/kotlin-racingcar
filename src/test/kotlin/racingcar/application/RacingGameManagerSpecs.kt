package racingcar.application

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingGameManagerSpecs : DescribeSpec({

    describe("경주 게임 관리자는") {
        context("주어진 입력에 따라 게임을 진행하면") {
            val numberOfCars = 3
            val numberOfPhase = 5
            val gameInput = GameInput(numberOfCars, numberOfPhase)
            it("게임 결과를 반환한다") {
                val gameResult = RacingGameManager.play(gameInput)
                with(gameResult) {
                    racingRecords.size shouldBe numberOfPhase
                }
            }
        }
    }
})
