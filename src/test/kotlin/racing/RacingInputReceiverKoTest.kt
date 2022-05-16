package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racing.view.RacingInputReceiver
import racing.view.UserInput

class RacingInputReceiverKoTest : DescribeSpec({
    describe("receive method") {
        forAll(
            row("Andy,Bruce,Clara\n4", listOf("Andy", "Bruce", "Clara"), 4),
            row("Andy\n25", listOf("Andy"), 25)
        ) { input, carNames, moveCount ->
            context("with user input : $input") {
                System.setIn(input.byteInputStream())

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
                System.setIn(input.byteInputStream())

                it("throws IllegalArgumentException") {
                    shouldThrow<IllegalArgumentException> {
                        RacingInputReceiver.receive()
                    }
                }
            }
        }
    }
})
