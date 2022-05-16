package racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.Row2
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.domain.RacingCars
import racing.domain.Winners
import racing.view.RacingUI
import java.io.ByteArrayOutputStream
import java.io.PrintStream

private val drawCarsTestData = listOf(
    RacingCars(listOf(Car("Andy", startPosition = 4), Car("Bruce", startPosition = 2))) to
        """
                |Andy : -----
                |Bruce : ---
                |
                |
            """.trimMargin(),
    RacingCars(listOf(Car("Andy", startPosition = 0))) to
        """
                |Andy : -
                |
                |
            """.trimMargin()
)

private fun generateDrawCarsTestRows(): List<Row2<RacingCars, String>> {
    return drawCarsTestData.map { (cars, expect) ->
        row(cars, expect)
    }
}

class RacingUIKoTest : DescribeSpec({
    val output = ByteArrayOutputStream()
    System.setOut(PrintStream(output))

    describe("drawCars method") {
        forAll(
            *generateDrawCarsTestRows().toTypedArray()
        ) { cars, expect ->
            context("with cars : $cars") {
                it("draw $expect") {
                    output.reset()
                    RacingUI.drawCars(cars)

                    output.toString() shouldBe expect
                }
            }
        }
    }

    describe("drawWinners Method") {
        context("with winner ( Andy )") {
            it("draw [ Andy가 최종 우승했습니다. ]") {
                output.reset()
                RacingUI.drawWinners(Winners(listOf("Andy")))

                output.toString().trimIndent() shouldBe "Andy가 최종 우승했습니다."
            }
        }
        context("with winner ( Andy, Bruce )") {
            it("draw [ Andy, Bruce가 최종 우승했습니다. ]") {
                output.reset()
                RacingUI.drawWinners(Winners(listOf("Andy", "Bruce")))

                output.toString().trimIndent() shouldBe "Andy, Bruce가 최종 우승했습니다."
            }
        }
    }
})
