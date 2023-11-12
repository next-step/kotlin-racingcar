package racingcar

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.RacingGame

class RacingGameTest : ShouldSpec({

    val tryCount = 10
    lateinit var cars: List<Car>

    beforeTest {
        cars = listOf(
            Car(name = "pobi"),
            Car(name = "crong"),
            Car(name = "honux")
        )
    }

    context("N대의 자동차를 M번 이동하는 게임이 시작되면") {
        should("M개의 게임결과가 반환된다") {
            val racingGameResults = RacingGame(cars, tryCount).run { 1 }
            racingGameResults.size shouldBe tryCount
        }

        should("각 게임결과에는 N대의 자동차가 이동한 결과가 저장된다") {
            val racingGameResults = RacingGame(cars, tryCount).run { 1 }
            racingGameResults.forAll { gameResult ->
                gameResult.cars.size shouldBe cars.size
            }
        }

        context("게임 횟수마다 자동차가 전진한다면") {
            should("각 자동차의 위치는 초기 위치로부터 tryCount 만큼 이동한 위치이다") {
                RacingGame(cars, tryCount).run { 4 }
                cars[0].location shouldBe tryCount
                cars[1].location shouldBe tryCount
                cars[2].location shouldBe tryCount
            }
        }

        context("게임 횟수마다 자동차가 정지한다면") {
            should("각 자동차의 위치는 초기 위치이다") {
                RacingGame(cars, tryCount).run { 0 }
                cars.forAll { it.location shouldBe 0 }
            }
        }
    }
})
