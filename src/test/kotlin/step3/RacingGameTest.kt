package step3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import step3.view.InputView
import step3.view.OutputView

class RacingGameTest : FreeSpec({
    "자동차 경주 요구 사항을 입력받아 경주 수행 결과물을 요구사항(차량 이름, 시도 횟수)에 맞게 출력한다." - {
        forAll(
            row(listOf("minsu", "hello"), 5),
            row(listOf("name", "magin", "rudra", "pizza"), 100)
        ) { carNames, numberOfTrials ->
            val fakeInputView = FakeInputView(carNames, numberOfTrials)
            val fakeOutputView = FakeOutputView(carNames)
            val sut = RacingManager(
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
    private val carNames: List<String>,
    private val numberOfTrials: Int
) : InputView {
    override fun askRequirement(): RacingRequirement {
        return RacingRequirement(carNames, numberOfTrials)
    }
}

private class FakeOutputView(
    private val testInputCarNames: List<String>
) : OutputView {
    var showResultTitleCalledCount = 0
        private set
    var showCurrentStatusCalledWithRightNumberOfCarsCount = 0
        private set

    override fun showResultTitle() {
        showResultTitleCalledCount++
    }

    override fun showStatus(carStatuses: List<CurrentCarStatus>) {
        if (testInputCarNames != carStatuses.map { it.carName }) return
        showCurrentStatusCalledWithRightNumberOfCarsCount++
    }
}
