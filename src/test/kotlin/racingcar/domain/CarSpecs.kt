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
                    Car(" ", RandomDriver)
                }
            }
        }
        context("이름이 1글자 미만이라면") {
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Car("", RandomDriver)
                }
            }
        }

        context("이름이 5글자를 초과한다면") {
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Car("123456", RandomDriver)
                }
            }
        }

        context("운전자가 전진하라는 이동 명령을 내리면") {
            val movements = listOf(4, 9)
            val car = Car("myCar", PreparedDriver(movements))
            it("앞으로 전진한다") {
                repeat(movements.size) {
                    val prevPosition = car.position
                    car.move()
                    car.position shouldBe (prevPosition + FORWARD.power)
                }
            }
        }

        context("이동 명령이 대기라면") {
            val movements = listOf(0, 3)
            val car = Car("myCar", PreparedDriver(movements))
            it("현재 위치에서 대기한다") {
                repeat(movements.size) {
                    val prevPosition = car.position
                    car.move()
                    car.position shouldBe (prevPosition + WAIT.power)
                }
            }
        }
    }
})
