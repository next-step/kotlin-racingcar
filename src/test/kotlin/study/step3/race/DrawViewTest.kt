package study.step3.race

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
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

    "Draw View 정상 테스트" {
        val drawView = DrawView(2)
        drawView.drawCarState(intArrayOf(1, 2), 1)
        val normalizedOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n")

        normalizedOutput shouldBe """
        |실행 결과
        |-
        |--
        """.trimMargin()
    }

    "IntArray 에 값이 0일 경우 표출되지 않음" {
        val drawView = DrawView(2)
        drawView.drawCarState(intArrayOf(0), 2)
        val normalizedOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n")

        normalizedOutput shouldBe """
        |실행 결과
        """.trimMargin()
    }

    "Draw View 마지막 줄에는 println 이 들어가지 않음" {
        val drawView = DrawView(2)
        drawView.drawCarState(intArrayOf(2), 2)
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
