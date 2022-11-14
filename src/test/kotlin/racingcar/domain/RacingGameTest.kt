package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import racingcar.RandomForward

internal class RacingGameTest : StringSpec({

    "게임 실행 횟수가 0이라면 모든 자동차는 움직이지 않는다." {
        val cars = listOf(
            Car("fir"),
            Car("sec")
        )
        val racingGame = RacingGame(cars, RandomForward())
        val playCount = 0
        val winners: List<String> = racingGame.play(playCount)

        winners shouldHaveSize cars.size
    }

    "게임 실행 횟수가 음수라면 예외가 발생한다." {
        val cars = listOf(
            Car("fir"),
            Car("sec")
        )
        val racingGame = RacingGame(cars, RandomForward())
        val playCount = -1

        shouldThrow<IllegalArgumentException> {
            racingGame.play(playCount)
        }
    }

    "자동차가 없다면 RacingGame 을 할 수 없다." {
        val cars = emptyList<Car>()

        shouldThrow<IllegalArgumentException> {
            RacingGame(cars, RandomForward())
        }
    }
})
