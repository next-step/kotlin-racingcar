package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.mockk.every
import io.mockk.mockk
import racingcar.RandomNumberUtils

class CarKoTest : DescribeSpec({
    describe("자동차 이동 테스트") {
        val randomNumberGenerator = mockk<RandomNumberUtils>()

        val car = Car("테스트 자동차")
        beforeEach { car.position = 0 }

        it("입력된 숫자가 4 이상이면 이동한다.") {
            every { randomNumberGenerator.getRandomNumber() } returns 4

            car.move(randomNumberGenerator.getRandomNumber())
            car.position shouldBeExactly 1
        }

        it("입력된 숫자가 4 미만이면 멈춰있는다.") {
            every { randomNumberGenerator.getRandomNumber() } returns 0

            car.move(randomNumberGenerator.getRandomNumber())
            car.position shouldBeExactly 0
        }
    }
})
