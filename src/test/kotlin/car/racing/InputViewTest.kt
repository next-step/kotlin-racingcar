package car.racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class InputViewTest : FreeSpec({
    "입력 화면" - {
        fun fakeConsole(@Suppress("UNUSED_PARAMETER") msg: String) = Unit

        "정상 입력으로 진행" - {
            var fakeReadValue: Int? = 0
            fun fakeReader(): String? = fakeReadValue?.toString()
            val inputView = InputView(::fakeReader, ::fakeConsole)

            "드라이버는 5명" {
                fakeReadValue = 5
                inputView.readDrivers() shouldBe fakeReadValue
            }

            "이동횟수는 3번" {
                fakeReadValue = 3
                inputView.readMoves() shouldBe fakeReadValue
            }
        }

        "비정상 입력으로 진행" - {
            var fakeReadValue: String? = null
            fun fakeReader(): String? = fakeReadValue
            val inputView = InputView(::fakeReader, ::fakeConsole)

            fakeReadValue = "a"
            "드라이버는 숫자가 아니기 때문에 IllegalArgumentException 발생" {
                shouldThrowExactly<IllegalArgumentException> {
                    inputView.readDrivers()
                }
            }

            fakeReadValue = "error"
            "이동횟수는 숫자가 아니기 때문에 IllegalArgumentException 발생" {
                shouldThrowExactly<IllegalArgumentException> {
                    inputView.readMoves()
                }
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
    }
})
