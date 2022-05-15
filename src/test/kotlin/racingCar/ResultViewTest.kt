package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ResultViewTest : DescribeSpec({
    describe("show") {
        it("자동차들의 위치 데이터를 출력한다.") {
            val stubDrawer = StubDrawer()
            val resultView = ResultView(stubDrawer)

            resultView.show(listOf(1, 2, 3))

            stubDrawer.view shouldBe "-\n" + "--\n" + "---"
        }
    }
})

class StubDrawer():IDrawer {
    lateinit var view: String

    override fun paintFor(view: String) {
        this.view = view
    }
}