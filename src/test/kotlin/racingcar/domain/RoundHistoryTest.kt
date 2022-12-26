package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RoundHistoryTest : DescribeSpec({
    describe("라운드 히스토리 테스트") {
        it("가장 앞선 position의 자동차들을 찾을 수 있다.") {
            val firstCar = Car("자동차1", 1)
            val secondCar = Car("자동차2", 2)
            val cars = Cars(listOf(firstCar, secondCar))

            val roundHistory = RoundHistory(1, cars)
            val winners = roundHistory.getWinners()

            winners shouldBe listOf(secondCar)
        }
    }
})
