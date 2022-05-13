package scene

import engine.EnvironmentManager
import engine.GameEngine
import fixture.StubEnvironmentModule
import fixture.StubOutputPainter
import fixture.StubRandomGenerator
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import model.ScoreBoard
import utils.Constants

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
            val outputPainter = StubOutputPainter()
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
            val result = outputPainter.outputBuffer.joinToString("")

            // then
            result shouldBe expectResult
        }

        it("PlayScene은 3이하의 랜덤값이 나오면 자동차는 정지한다.") {
            // given
            val stubEnvironmentModule = StubEnvironmentModule()
            val environmentManager = EnvironmentManager(stubEnvironmentModule)
            val round = "2"
            val player = "2"
            environmentManager.put(Constants.CAR_NUMBER_KEY, player)
            environmentManager.put(Constants.STAGE_NUMBER_KEY, round)
            val outputPainter = StubOutputPainter()
            val scoreBoard = ScoreBoard(outputPainter)
            val successfulRandomGenerator = StubRandomGenerator(3)
            val playScene = PlayScene(outputPainter, scoreBoard, successfulRandomGenerator, environmentManager)
            val expectResult = """
                
                실행결과
                
                
                
                
                
                
                
            """.trimIndent()

            // when
            GameEngine.run(playScene)
            val result = outputPainter.outputBuffer.joinToString("")

            // then
            result shouldBe expectResult
        }
    }
})
