package study.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import java.io.ByteArrayInputStream

/**
 * @author 이상준
 */
class RacingCarGameTest : StringSpec({
    "자동차 게임 설정 Input 테스트" {
        val racingCarGameSettings = RacingCarGameSettings()
        val gameSettings: GameSettings

        val input = "3\n5\n"
        val fakeInputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(fakeInputStream)

        gameSettings = racingCarGameSettings.inputBySettings()

        gameSettings.carCount shouldBe 3
        gameSettings.racingCount shouldBe 5
    }

    "자동차 게임 설정 Input 예외" {
        val racingCarGameSettings = RacingCarGameSettings()

        var input = "aa\n5\n"
        var fakeInputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(fakeInputStream)

        var exception =
            shouldThrow<IllegalArgumentException> {
                racingCarGameSettings.inputBySettings()
            }
        exception.message should startWith("For input")

        input = "3\nbb\n"
        fakeInputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(fakeInputStream)

        exception =
            shouldThrow<IllegalArgumentException> {
                racingCarGameSettings.inputBySettings()
            }
        exception.message should startWith("For input")
    }
})
