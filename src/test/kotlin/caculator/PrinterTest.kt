package caculator

import calculator.Printer
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.system.captureStandardOut
import io.kotest.matchers.shouldBe

class PrinterTest : StringSpec({
    "정수가 출력된다" {
        val data = 3

        val output = captureStandardOut {
            Printer.printInt(data)
        }

        output shouldBe "3\n"
    }
})
