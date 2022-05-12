package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.Row3
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racing.view.RacingInputReceiver
import racing.view.UserInput
import java.io.ByteArrayInputStream

private val userInputTestData = listOf(
    Triple("Andy,Bruce,Clara\n4", listOf("Andy", "Bruce", "Clara"), 4),
    Triple("Andy,Clara\n25", listOf("Andy", "Clara"), 25),
)

private fun generateUserInputTestRows(): List<Row3<String, List<String>, Int>> {
    return userInputTestData.map { (input, expectNames, expectCount) ->
        row(input, expectNames, expectCount)
    }
}

class RacingInputReceiverKoTest : DescribeSpec({
    describe("receive method") {
        forAll(
            *generateUserInputTestRows().toTypedArray()
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
