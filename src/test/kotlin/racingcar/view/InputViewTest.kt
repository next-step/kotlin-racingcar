package racingcar.view

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.view.input.Input

class InputViewTest : AnnotationSpec() {
    @Test
    fun `Input 의 결과를 보관한다`() {
        val expectCarCount = 5
        val expectTryCount = 3
        val input = StubInput(expectCarCount, expectTryCount)
        val sut = InputView(input)

        sut.start()

        sut.carCount shouldBe expectCarCount
        sut.tryCount shouldBe expectTryCount
    }
}

class StubInput(private val carCount: Int, private val tryCount: Int) : Input {
    override fun readCar(): Int {
        return this.carCount
    }

    override fun readTry(): Int {
        return this.tryCount
    }
}
