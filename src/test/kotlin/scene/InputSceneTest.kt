package scene

import dto.InputResult
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import port.InputSystem
import port.OutputPainter

class StubOutputPainter : OutputPainter {

    val outputBuffer = mutableListOf<String>()

    override fun draw(buffer: String) {
        outputBuffer.add(buffer)
    }
}

class StubInputSystem(private val inputBuffer: List<String>) : InputSystem {

    private var index = 0

    override fun read(): String = inputBuffer[index++]
}

internal class InputSceneTest : DescribeSpec({

    describe("입력 장면 테스트") {
        it("사용자로부터 라운드와 플레이어 수를 입력받아 입력 Dto를 반환한다.") {
            // given
            val round = "5"
            val player = "3"
            val stubInputSystem = StubInputSystem(listOf(round, player))
            val stubOutputPainter = StubOutputPainter()
            val inputScene = InputScene(stubOutputPainter, stubInputSystem)

            // when
            val result = inputScene.update()

            // then
            stubOutputPainter.outputBuffer.size shouldBe 2
            result shouldBe InputResult(5, 3)
        }
    }
})
