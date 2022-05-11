package racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarRacingKoTest : DescribeSpec({
    describe("run method") {
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        val expect =
            """
                |Andy : -
                |Bruce : -
                |
                |Andy : --
                |Bruce : --
                |
                |Andy : ---
                |Bruce : ---
                |
                |Andy, Bruce가 최종 우승했습니다.
                |
            """.trimMargin()

        context("both cars ( Andy, Bruce ) move by moveCount") {
            it("draw car name and location for each turn, and draw the winner at the end") {

                CarRacing(
                    powerStrategy = StaticPowerStrategy(power = 10)
                ).run(UserInput(carNames = listOf("Andy", "Bruce"), moveCount = 2))

                output.toString() shouldBe expect
            }
        }
    }
})
