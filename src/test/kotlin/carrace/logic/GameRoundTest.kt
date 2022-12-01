package carrace.logic

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import kotlin.random.Random

/**
 * @see GameRound
 */
class GameRoundTest : FunSpec({

    context("GameRoundTest 단위 테스트") {
        test("입력이 숫자면 정상 생성 된다") {
            val normalInput = Random.nextInt(0, Int.MAX_VALUE).toString()

            shouldNotThrowAny { GameRound.from(normalInput) }
        }

        test("입력이 0 음수면 IllegalArgumentException이 반환된다.") {
            val minusInput = Random.nextInt(Int.MIN_VALUE, -1).toString()

            shouldThrowExactly<IllegalArgumentException> { GameRound.from(minusInput) }
        }

        test("입력이 숫자가 아니면 IllegalArgumentException이 반환된다.") {
            val notLongInputs = listOf("1.1", "숫자", "number")

            notLongInputs.forEach { notLongInput ->
                shouldThrowExactly<IllegalArgumentException> { GameRound.from(notLongInput) }
            }
        }
    }
})
