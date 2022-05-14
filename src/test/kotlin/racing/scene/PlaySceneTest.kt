package racing.scene

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racing.engine.EnvironmentManager
import racing.engine.GameEngine
import racing.fixture.StubEnvironmentModule
import racing.fixture.StubRandomGenerator
import racing.model.ScoreBoard
import racing.port.OutputPainter
import racing.utils.Constants

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
            val stubEnvironmentModule = StubEnvironmentModule()
            val environmentManager = EnvironmentManager(stubEnvironmentModule)
            val round = "2"
            val player = "2"
            environmentManager.put(Constants.CAR_NUMBER_KEY, player)
            environmentManager.put(Constants.STAGE_NUMBER_KEY, round)
            val outputPainter = StubPlaySceneOutputPainter()
            val scoreBoard = ScoreBoard(outputPainter)
            val successfulRandomGenerator = StubRandomGenerator(4)
            val playScene = PlayScene(outputPainter, scoreBoard, successfulRandomGenerator, environmentManager)
            val expectResult = """
                
                실행결과
                -
                -
                
                --
                --
                
                
            """.trimIndent()

            // when
            GameEngine.run(playScene)

            // then
            outputPainter.outputBuffer.joinToString("") shouldBe expectResult
        }

        it("PlayScene은 3이하의 랜덤값이 나오면 자동차는 정지한다.") {
            // given
            val stubEnvironmentModule = StubEnvironmentModule()
            val environmentManager = EnvironmentManager(stubEnvironmentModule)
            val round = "2"
            val player = "2"
            environmentManager.put(Constants.CAR_NUMBER_KEY, player)
            environmentManager.put(Constants.STAGE_NUMBER_KEY, round)
            val outputPainter = StubPlaySceneOutputPainter()
            val scoreBoard = ScoreBoard(outputPainter)
            val successfulRandomGenerator = StubRandomGenerator(3)
            val playScene = PlayScene(outputPainter, scoreBoard, successfulRandomGenerator, environmentManager)
            val expectResult = """
                
                실행결과
                
                
                
                
                
                
                
            """.trimIndent()

            // when
            GameEngine.run(playScene)

            // then
            outputPainter.outputBuffer.joinToString("") shouldBe expectResult
        }
    }
})
