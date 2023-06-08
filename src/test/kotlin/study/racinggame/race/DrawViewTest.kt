package study.racinggame.race

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racinggame.domain.CarResponse
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
        val drawView = DrawView(2)
        drawView.drawCarState(listOf(CarResponse(1), CarResponse(2)), 1)
        val normalizedOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n")

        normalizedOutput shouldBe """
        |실행 결과
        |-
        |--
        """.trimMargin()
    }

    "position 이 0일 경우 표출되지 않음" {
        val drawView = DrawView(2)
        drawView.drawCarState(listOf(CarResponse(0)), 2)
        val normalizedOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n")

        normalizedOutput shouldBe """
        |실행 결과
        """.trimMargin()
    }

    "Draw View 마지막 줄에는 println 이 들어가지 않음" {
        val drawView = DrawView(2)
        drawView.drawCarState(listOf(CarResponse(2)), 2)
        val normalizedOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n")

        normalizedOutput shouldBe """
        |실행 결과
        |--
        """.trimMargin()
    }

    afterTest {
        System.setOut(standardOut)
    }
})
