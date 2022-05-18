package racing.scene

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racing.dto.InputDto
import racing.fixture.StubRandomGenerator
import racing.port.OutputPainter

class StubPlaySceneOutputPainter : OutputPainter {

    val outputBuffer: MutableList<String> = mutableListOf()

    override fun draw(buffer: String) {
        outputBuffer += buffer
    }
}

internal class PlaySceneTest : DescribeSpec({

    describe("PlayScene 테스트") {
        it("PlayScene은 4이상의 랜덤값이 나오면 자동차는 전진한다.") {
            // given
            val round = 2
            val players = listOf("yohan", "kbs")
            val inputDto = InputDto(players, round)
            val outputPainter = StubPlaySceneOutputPainter()
            val successfulRandomGenerator = StubRandomGenerator(4)
            val playScene = PlayScene(inputDto, outputPainter, successfulRandomGenerator)
            val expectResult = """
                
                실행결과
                yohan: -
                kbs: -
                
                yohan: --
                kbs: --
                
                yohan, kbs가 최종 우승했습니다.
            """.trimIndent()

            // when
            playScene.run().draw()

            // then
            outputPainter.outputBuffer.joinToString("") shouldBe expectResult
        }

        it("PlayScene은 3이하의 랜덤값이 나오면 자동차는 정지한다.") {
            // given
            val round = 2
            val players = listOf("yohan", "kbs")
            val inputDto = InputDto(players, round)
            val outputPainter = StubPlaySceneOutputPainter()
            val successfulRandomGenerator = StubRandomGenerator(3)
            val playScene = PlayScene(inputDto, outputPainter, successfulRandomGenerator)
            val expectResult = """
                
                실행결과
                yohan: 
                kbs: 
                
                yohan: 
                kbs: 
                
                yohan, kbs가 최종 우승했습니다.
            """.trimIndent()

            // when
            playScene.run().draw()

            // then
            outputPainter.outputBuffer.joinToString("") shouldBe expectResult
        }
    }
})
