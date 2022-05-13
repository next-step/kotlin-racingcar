package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class InputViewTest : DescribeSpec({
    describe("askCarCount") {
        it("carCount 를 입력 받아서 리턴한다.") {
            val expectCarCount = InputView(StubInput(3, 4)).askCarCount()

            expectCarCount shouldBe 3
        }
    }

    describe("askTryCount") {
        it("carCount 를 입력 받아서 리턴한다.") {
            val expectTryCount = InputView(StubInput(3, 4)).askTryCount()

            expectTryCount shouldBe 4
        }
    }
})

class StubInput(private val carCount: Int, private val tryCount: Int): IInput {
    override fun receiveCarCount(): Int {
        return carCount
    }

    override fun receiveTryCount(): Int {
        return tryCount
    }
}