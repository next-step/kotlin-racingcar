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
                    Car(1),
                    Car(2),
                    Car(3),
                )
            )
            val scoreBoard = ScoreBoard(listOf(cars), stubOutputPainter)

            // when
            scoreBoard.draw()

            // then
            val expectedResult = """
                
                실행결과
                unknown: -
                unknown: --
                unknown: ---
                
                unknown가 최종 우승했습니다.
            """.trimIndent()
            stubOutputPainter.outputBuffer.joinToString("") shouldBe expectedResult
        }

        it("위치가 0인 자동차도 출력한다.") {
            // given
            val stubOutputPainter = StubOutputPainter()
            val cars = Cars(
                listOf(
                    Car(0),
                    Car(2),
                    Car(3),
                )
            )
            val scoreBoard = ScoreBoard(listOf(cars), stubOutputPainter)

            // when
            scoreBoard.draw()

            // then
            val expectedResult = """
                
                실행결과
                unknown: 
                unknown: --
                unknown: ---
                
                unknown가 최종 우승했습니다.
            """.trimIndent()
            stubOutputPainter.outputBuffer.joinToString("") shouldBe expectedResult
        }
    }
})
