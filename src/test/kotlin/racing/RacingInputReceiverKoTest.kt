package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream

class RacingInputReceiverKoTest : DescribeSpec({
    describe("receive method") {
        forAll(
            row("5\n3", 5, 3),
            row("3\n3", 3, 3),
            row("13\n1", 13, 1)
        ) { input, carNumber, moveCount ->
            context("with user input : $input") {
                System.setIn(ByteArrayInputStream(input.toByteArray()))

                it("returns ${UserInput(carNumber, moveCount)}") {
                    RacingInputReceiver().receive() shouldBe UserInput(carNumber, moveCount)
                }
            }
        }

        forAll(
            row(""),
            row("    "),
            row("자동차10대"),
            row("지나가던강아지 한마리"),
            row("IDontKnowKorean")
        ) { input ->
            context("with wrong user Input : ( $input )") {
                System.setIn(ByteArrayInputStream(input.toByteArray()))

                it("throws IllegalArgumentException") {
                    shouldThrow<IllegalArgumentException> {
                        RacingInputReceiver().receive()
                    }
                }
            }
        }
    }
})
