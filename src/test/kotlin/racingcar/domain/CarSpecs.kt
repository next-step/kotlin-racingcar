package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.MovementCommand.FORWARD
import racingcar.domain.MovementCommand.WAIT

class CarSpecs : DescribeSpec({

    describe("자동차는") {
        val car = Car()
        context("이동 명령이 전진이라면") {
            val command = FORWARD
            it("앞으로 전진한다") {
                val prevPosition = car.position
                car.move(command)
                car.position shouldBe (prevPosition + 1)
            }
        }

        context("이동 명령이 대기라면") {
            val command = WAIT
            it("현재 위치에서 대기한다") {
                val prevPosition = car.position
                car.move(command)
                car.position shouldBe prevPosition
            }
        }
    }
})
