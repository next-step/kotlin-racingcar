package step3.carRacing.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

import step3.carRacing.model.Car

class OutputViewTest : StringSpec({
    "자동차 인스턴스와 라운드를 넣으면 자동차 경기를 렌더한다" {
        class MockPrinter : Print {
            private val output = StringBuilder()
            override fun print(string: String) {
                output.append(string)
            }

            override fun println(string: String) {
                output.append(string)
            }

            fun getOutput(): String {
                return output.toString()
            }
        }

        val mockPrinter = MockPrinter()

        OutputView.renderRace(1, listOf(Car(3), Car(0), Car(1)), mockPrinter)

        mockPrinter.getOutput() shouldBe "<-------------- 2 Round Race \uD83C\uDFCE️ -------------->---\n" + "\n" + "-" + "\n"
    }
})
