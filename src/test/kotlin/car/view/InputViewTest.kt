package car.view

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveUpperBound
import io.kotest.matchers.shouldBe

class InputViewTest : FreeSpec({
    "입력 화면" - {
        fun fakeConsole(@Suppress("UNUSED_PARAMETER") msg: String) = Unit

        "정상 입력으로 진행" - {
            val driverNames = listOf("마루", "벨라", "배추", "여름", "율무")
            var fakeReadValue: Any? = null
            fun fakeReader(): String? = fakeReadValue?.toString()
            val inputView = InputView(::fakeReader, ::fakeConsole)

            "드라이버는 5명" {
                fakeReadValue = driverNames.joinToString()
                inputView.readDriverNames().size shouldBe driverNames.size
            }

            "이동횟수는 3번" {
                fakeReadValue = 3
                inputView.readMoves() shouldBe fakeReadValue
            }

            val driverName = driverNames.random()
            forAll(
                row(",$driverName"),
                row("$driverName,"),
                row(",$driverName,"),
                row(",,$driverName"),
                row("$driverName,,"),
            ) {
                "드라이버 이름 입력에 콤마가 앞뒤로 여러개 있어도 정상 (입력: $it)" {
                    fakeReadValue = it
                    inputView.readDriverNames().size shouldBe 1
                    inputView.readDriverNames().first() shouldBe driverName
                }
            }
        }

        "5자 이상의 길이로 이름을 입력으로 진행" - {
            val driverLongNames = listOf("강된장콩나물비빔밥", "딸기쉐이크", "콩")
            var fakeReadValue: Any? = null
            fun fakeReader(): String? = fakeReadValue?.toString()
            val inputView = InputView(::fakeReader, ::fakeConsole)

            fakeReadValue = driverLongNames.joinToString()
            "드라이버의 이름은 최대 5자로 이하로 되어 있다" {
                val driverNames = inputView.readDriverNames()
                driverNames.map { it.length } shouldHaveUpperBound 5
            }
        }

        "비정상 입력으로 진행" - {
            var fakeReadValue: String? = null
            fun fakeReader(): String? = fakeReadValue
            val inputView = InputView(::fakeReader, ::fakeConsole)

            forAll(
                row(""),
                row(" , "),
                row(",,,, "),
                row(" , , , , "),
            ) {
                fakeReadValue = it
                "드라이버 이름은 빈상태로 있을 수 없기 때문에 IllegalArgumentException 발생 (입력: $it)" {
                    shouldThrowExactly<IllegalArgumentException> {
                        inputView.readDriverNames()
                    }
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
                    inputView.readDriverNames()
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
