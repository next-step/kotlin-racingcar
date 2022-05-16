package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.MovementCommand.FORWARD
import racingcar.domain.MovementCommand.WAIT

class CarSpecs : DescribeSpec({

    describe("자동차는") {
        context("이름이 공백이라면") {
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Car(" ")
                }
            }
        }
        context("이름이 1글자 미만이라면") {
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Car("")
                }
            }
        }

        context("이름이 5글자를 초과한다면") {
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Car("123456")
                }
            }
        }

        context("이동 명령이 전진이라면") {
            val car = Car("myCar")
            val command = FORWARD
            it("앞으로 전진한다") {
                val prevPosition = car.position
                car.move(command)
                car.position shouldBe (prevPosition + 1)
            }
        }

        context("이동 명령이 대기라면") {
            val car = Car("myCar")
            val command = WAIT
            it("현재 위치에서 대기한다") {
                val prevPosition = car.position
                car.move(command)
                car.position shouldBe prevPosition
            }
        }
    }
})
