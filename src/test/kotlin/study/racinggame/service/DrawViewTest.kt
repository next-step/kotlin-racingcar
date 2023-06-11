package study.racinggame.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racinggame.presentation.dto.CarResponse
import study.racinggame.presentation.view.DrawView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class DrawViewTest : StringSpec({

    lateinit var standardOut: PrintStream
    lateinit var outputStreamCaptor: ByteArrayOutputStream

    beforeTest {
        standardOut = System.out
        outputStreamCaptor = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStreamCaptor))
    }

    "drawCarState 메소드 정상 작동" {
        val drawView = DrawView()
        drawView.drawCarState(listOf(CarResponse(1, "test"), CarResponse(2, "test2")))
        val normalizedOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n")

        normalizedOutput shouldBe """
        |실행 결과
        |test : -
        |test2 : --
        """.trimMargin()
    }

    afterTest {
        System.setOut(standardOut)
    }
})
