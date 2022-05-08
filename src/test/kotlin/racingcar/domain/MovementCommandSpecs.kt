package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.MovementCommand.FORWARD
import racingcar.domain.MovementCommand.WAIT

class MovementCommandSpecs : DescribeSpec({

    describe("이동 명령은") {
        context("입력 숫자가 0 ~ 3 사이 숫자면") {
            val number = 0
            it("대기 명령을 의미한다") {
                MovementCommand.of(number) shouldBe WAIT
            }
        }

        context("입력 숫자가 4 ~ 9 사이 숫자면") {
            val number = 4
            it("전진 명령을 의미한다") {
                MovementCommand.of(number) shouldBe FORWARD
            }
        }

        context("입력 숫자가 0 ~ 9를 벗어나면") {
            val number = 100
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> { MovementCommand.of(number) }
            }
        }
    }
})
