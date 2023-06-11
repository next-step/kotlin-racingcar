package study.racinggame.presentation

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racinggame.service.mock.MockInputReader
import study.racinggame.service.mock.MockRandom
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RaceControllerTest : StringSpec({

    lateinit var standardOut: PrintStream
    lateinit var outputStreamCaptor: ByteArrayOutputStream

    beforeTest {
        standardOut = System.out
        outputStreamCaptor = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStreamCaptor))
    }

    "컨트롤러가 정상적으로 등록되고, 작동에 에러가 없다." {
        val mockInputReader = MockInputReader(listOf("park,sejun", "1"))
        val mockRandom = MockRandom(Int.MAX_VALUE)
        val controller = RaceController(mockInputReader, mockRandom)
        controller.startRace()

        val normalizedOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n")

        normalizedOutput shouldBe """
        |실행 결과
        |경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
        |시도할 횟수는 몇 회인가요?
        |
        |park : --
        |sejun : --
        |
        |park, sejun님이 최종 우승했습니다.
        """.trimMargin()
    }

    afterTest {
        System.setOut(standardOut)
    }
})
