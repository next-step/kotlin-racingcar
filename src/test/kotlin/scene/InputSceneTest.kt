package scene

import engine.EnvironmentManager
import engine.GameEngine
import fixture.StubEnvironmentModule
import fixture.StubInputSystem
import fixture.StubOutputPainter
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import utils.Constants

internal class InputSceneTest : DescribeSpec({

    describe("InputScene 테스트") {
        it("InputScene은 자동차 수와 라운드를 입력받아 저장한다.") {
            // given
            val stubEnvironmentModule = StubEnvironmentModule()
            val environmentManager = EnvironmentManager(stubEnvironmentModule)
            val outputPainter = StubOutputPainter()
            val inputSystem = StubInputSystem(listOf("1", "2"))
            val inputScene = InputScene(outputPainter, inputSystem, environmentManager)

            // when
            GameEngine.run(inputScene)

            // then
            environmentManager.get(Constants.CAR_NUMBER_KEY) shouldBe "1"
            environmentManager.get(Constants.STAGE_NUMBER_KEY) shouldBe "2"
        }
    }
})
