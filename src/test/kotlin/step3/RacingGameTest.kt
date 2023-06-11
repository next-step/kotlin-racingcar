package step3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import step3.view.InputView
import step3.view.OutputView

class RacingGameTest : FreeSpec({
    "자동차 경주 요구 사항을 입력받아 경주 수행 결과물을 요구사항(차량, 시도 횟수)에 맞게 출력한다." - {
        forAll(
            row(3, 5),
            row(4, 100)
        ) { numberOfCars, numberOfTrials ->
            val fakeInputView = FakeInputView(numberOfCars, numberOfTrials)
            val fakeOutputView = FakeOutputView(numberOfCars)
            val sut = RacingGame(
                inputView = fakeInputView,
                outputView = fakeOutputView
            )

            sut.run()

            fakeOutputView.showResultTitleCalledCount shouldBe 1
            fakeOutputView.showCurrentStatusCalledWithRightNumberOfCarsCount shouldBe numberOfTrials
        }
    }
})

private class FakeInputView(
    private val numberOfCars: Int,
    private val numberOfTrials: Int
) : InputView {
    override fun askRequirement(): RacingRequirement {
        return RacingRequirement(numberOfCars, numberOfTrials)
    }
}

private class FakeOutputView(
    private val numberOfCars: Int
) : OutputView {
    var showResultTitleCalledCount = 0
        private set
    var showCurrentStatusCalledWithRightNumberOfCarsCount = 0
        private set

    override fun showResultTitle() {
        showResultTitleCalledCount++
    }

    override fun showStatus(distanceResult: List<Distance>) {
        if (distanceResult.size != numberOfCars) return
        showCurrentStatusCalledWithRightNumberOfCarsCount++
    }
}
