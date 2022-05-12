package racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.Row2
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.ui.RacingUI
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.random.Random

private val names = listOf("Andy", "Bruce", "Clara", "David", "Echo", "Flora")
private val random = Random(123456789)

private fun generateDrawCarsTestData(): Row2<List<Car>, String> {
    val cars = generateCars()

    return row(cars, generateDrawCarExcept(cars))
}

private fun generateCars(): List<Car> {
    val carNames = names.shuffled(random).take(random.nextInt(8))

    return carNames.map { Car(name = it, startPosition = random.nextInt(10)) }
}

private fun generateDrawCarExcept(cars: List<Car>): String {
    return cars.joinToString(separator = "\n", postfix = "\n\n") { car ->
        "${car.name} : ${"-".repeat(car.position + 1)}"
    }
}

class RacingUIKoTest : DescribeSpec({
    val output = ByteArrayOutputStream()
    System.setOut(PrintStream(output))

    describe("drawCars method") {
        forAll(
            generateDrawCarsTestData(),
            generateDrawCarsTestData(),
            generateDrawCarsTestData()
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
                RacingUI.drawWinners(listOf(Car("Andy")))

                output.toString().trimIndent() shouldBe "Andy가 최종 우승했습니다."
            }
        }
        context("with winner ( Andy, Bruce )") {
            it("draw [ Andy, Bruce가 최종 우승했습니다. ]") {
                output.reset()
                RacingUI.drawWinners(listOf(Car("Andy"), Car("Bruce")))

                output.toString().trimIndent() shouldBe "Andy, Bruce가 최종 우승했습니다."
            }
        }
    }
})
