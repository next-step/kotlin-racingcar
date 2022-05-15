package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.*


class RaceGameTest : DescribeSpec({
    describe("start") {
        it("race 가 시작된다.") {
            val race = mockk<Race>()
            every { race.run() } just Runs
            val raceGame = RaceGame(InputView(StubInput(3, 4)), ResultView(StubDrawer()))

            raceGame.start()

            verify { race.run() }
        }

        it("차들의 위치를 표현한다.") {
            val race = mockk<Race>()
            every { race.run() } just Runs
            val stubDrawer = StubDrawer()
            val raceGame = RaceGame(InputView(StubInput(3, 4)), ResultView(stubDrawer))

            raceGame.start()

            every { race.carPositions } returns mutableListOf(1, 2, 3)

            stubDrawer.view shouldBe "-\n" + "--\n" + "---"
        }
    }
})
