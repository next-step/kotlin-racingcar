package car.racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarRacingTest : FreeSpec({

    "입력 화면" - {
        var fakeReadValue: Int? = 0
        fun fakeReader(): String? = fakeReadValue?.toString()
        fun fakeConsole(@Suppress("UNUSED_PARAMETER") msg: String) = Unit
        val inputView = InputView(::fakeReader, ::fakeConsole)

        "드라이버는 5명" {
            fakeReadValue = 5
            inputView.readDrivers() shouldBe fakeReadValue
        }

        "이동횟수는 3번" {
            fakeReadValue = 3
            inputView.readMoves() shouldBe fakeReadValue
        }

        fakeReadValue = null
        "드라이버는 null 이기 때문에 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                inputView.readDrivers()
            }
        }

        "이동횟수는 null 이기 때문에 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                inputView.readMoves()
            }
        }
    }
})
