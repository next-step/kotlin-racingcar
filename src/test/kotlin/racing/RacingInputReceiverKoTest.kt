package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.Row3
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
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
                    RacingInputReceiver().receive() shouldBe UserInput(carNames, moveCount)
                }
            }
        }

        forAll(
            row(" "),
            row("    "),
            row("이름이 너무긴 사용자,두번째로긴사람\n5"),
            row("자동차10대\n3"),
            row("지나가던강아지 한마리\n숫자가아니다."),
            row("David\n숫자가 아니다."),
            row("David,Dwen\n-1245234")
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
