package racing.scene

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racing.engine.EnvironmentManager
import racing.engine.GameEngine
import racing.fixture.StubEnvironmentModule
import racing.fixture.StubInputSystem
import racing.fixture.StubOutputPainter
import racing.utils.Constants

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
