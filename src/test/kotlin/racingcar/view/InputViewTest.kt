package racingcar.view

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.StubInput

class InputViewTest : AnnotationSpec() {
    @Test
    fun `Input 의 결과를 보관한다`() {
        val expectCarCount = 5
        val expectTryCount = 3
        val input = StubInput(expectCarCount, expectTryCount)

        val sut = InputView(input)

        sut.carCount shouldBe expectCarCount
        sut.tryCount shouldBe expectTryCount
    }
}

