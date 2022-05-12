package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.Row3
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racing.ui.RacingInputReceiver
import racing.ui.UserInput
import java.io.ByteArrayInputStream
import kotlin.random.Random

private val random = Random(123456789)

private val names = listOf("Andy", "Bruce", "Clara", "David", "Echo", "Flora")
private fun generateInput(names: List<String>, moveCount: Int): String {
    return "${names.joinToString(",")}\n$moveCount"
}

private fun generateUserInputTestData(): Row3<String, List<String>, Int> {
    val randomNames = names.shuffled(random).drop(3)
    val moveCount = random.nextInt(0, 100)

    return row(generateInput(randomNames, moveCount), randomNames, moveCount)
}

class RacingInputReceiverKoTest : DescribeSpec({
    describe("receive method") {
        forAll(
            generateUserInputTestData(),
            generateUserInputTestData(),
            generateUserInputTestData()
        ) { input, carNames, moveCount ->
            context("with user input : $input") {
                System.setIn(ByteArrayInputStream(input.toByteArray()))

                it("returns ${UserInput(carNames, moveCount)}") {
                    RacingInputReceiver.receive() shouldBe UserInput(carNames, moveCount)
                }
            }
        }

        forAll(
            row(" "),
            row("    "),
        ) { input ->
            context("with empty or blank Input : ( $input )") {
                System.setIn(ByteArrayInputStream(input.toByteArray()))

                it("throws IllegalArgumentException") {
                    shouldThrow<IllegalArgumentException> {
                        RacingInputReceiver.receive()
                    }
                }
            }
        }
    }
})
