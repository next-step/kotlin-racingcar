package racing.scene

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racing.fixture.StubInputSystem
import racing.fixture.StubOutputPainter

internal class InputSceneTest : DescribeSpec({

    describe("InputScene 테스트") {
        it("InputScene은 자동차 수와 라운드를 입력받아 저장한다.") {
            // given
            val outputPainter = StubOutputPainter()
            val expectedNames = "mbc,kbs"
            val expectedRound = "2"
            val inputSystem = StubInputSystem(listOf(expectedNames, expectedRound))
            val inputScene = InputScene(outputPainter, inputSystem)

            // when
            val result = inputScene.getGameInformation()

            // then
            result.round shouldBe expectedRound.toInt()
            result.names shouldBe listOf("mbc", "kbs")
        }
    }
})
