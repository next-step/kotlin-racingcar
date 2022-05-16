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
            val expectedNames = "mbc,kbs,jtbc,sbs"
            val expectedRound = "2"
            val inputSystem = StubInputSystem(listOf(expectedNames, expectedRound))
            val inputScene = InputScene(outputPainter, inputSystem, environmentManager)

            // when
            GameEngine.run(inputScene)

            // then
            environmentManager.get(Constants.CAR_NAMES_KEY) shouldBe expectedNames
            environmentManager.get(Constants.STAGE_NUMBER_KEY) shouldBe expectedRound
        }
    }
})
