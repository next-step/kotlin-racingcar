package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.MovementCommand.FORWARD
import racingcar.domain.MovementCommand.WAIT

class RacingCarsSpecs : DescribeSpec({

    describe("경주에 참여한 자동차들은") {
        val car1 = Car()
        val car2 = Car()
        val car3 = Car()
        val racingCars = RacingCars(
            listOf(
                car1,
                car2,
                car3
            )
        )
        context("이동 명령이 주어지면") {
            val commands = listOf(
                FORWARD,
                WAIT,
                FORWARD
            )
            it("각 자동차별로 이동 명령을 적용한다") {
                racingCars.execute(commands)
                car1.position shouldBe 1
                car2.position shouldBe 0
                car3.position shouldBe 1
            }
        }
        context("주어진 이동 명령의 수와 자동차의 수가 일치하지 않으면") {
            val commands = listOf(
                FORWARD,
                WAIT
            )
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> { racingCars.execute(commands) }
            }
        }
    }
})
