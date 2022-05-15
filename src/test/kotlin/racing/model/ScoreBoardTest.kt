package racing.model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racing.fixture.StubOutputPainter

internal class ScoreBoardTest : DescribeSpec({

    describe("전광판 객체 테스트") {
        it("입력된 모든 자동차의 현재 위치를 출력한다.") {
            // given
            val stubOutputPainter = StubOutputPainter()
            val cars = Cars(
                listOf(
                    Car.spawnAt(1),
                    Car.spawnAt(2),
                    Car.spawnAt(3),
                )
            )
            val scoreBoard = ScoreBoard(stubOutputPainter)

            // when
            scoreBoard.draw(cars)

            // then
            val expectedResult = """
                -
                --
                ---
            """.trimIndent()
            stubOutputPainter.outputBuffer shouldBe expectedResult
        }

        it("위치가 0인 자동차도 출력한다.") {
            // given
            val stubOutputPainter = StubOutputPainter()
            val cars = Cars(
                listOf(
                    Car.spawnAt(0),
                    Car.spawnAt(2),
                    Car.spawnAt(3),
                )
            )
            val scoreBoard = ScoreBoard(stubOutputPainter)

            // when
            scoreBoard.draw(cars)

            // then
            val expectedResult = """
                
                --
                ---
            """.trimIndent()
            stubOutputPainter.outputBuffer shouldBe expectedResult
        }

        it("입력된 자동차가 없는 경우 출력하지 않는다.") {
            // given
            val stubOutputPainter = StubOutputPainter()
            val cars = Cars.empty()
            val scoreBoard = ScoreBoard(stubOutputPainter)

            // when
            scoreBoard.draw(cars)

            // then
            stubOutputPainter.outputBuffer shouldBe ""
        }
    }
})
