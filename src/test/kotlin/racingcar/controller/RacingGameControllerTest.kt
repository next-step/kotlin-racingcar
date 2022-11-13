package racingcar.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.spyk
import io.mockk.verify
import racingcar.domain.racing_game.CompeteRacingGame
import racingcar.domain.racing_game.DefaultRacingGame
import racingcar.domain.random.DefaultRandomGenerator
import racingcar.model.Car
import racingcar.model.CompeteCar
import racingcar.model.DefaultCar

class RacingGameControllerTest : BehaviorSpec({
    given("레이싱게임에 차를 5대 등록한다") {
        val cars = ArrayList<Car>().apply {
            repeat(5) { add(DefaultCar()) }
        }
        val racingGame = spyk(DefaultRacingGame(DefaultRandomGenerator(), cars))
        val racingGameController = RacingGameController(racingGame)
        then("5대의 차가 레이싱을 준비한다") {
            racingGame.cars.size shouldBe 5
        }
        `when`("실행횟수를 지정하여 레이싱 게임을 시작하면") {
            racingGameController.doRacingGame(5)
            then("지정한 실행횟수만큼 레이싱을 한다") {
                verify(exactly = 5) { racingGame.race() }
            }
        }
    }

    given("순위를 결정하는 레이싱게임을 한다") {
        val cars = listOf(CompeteCar("Kim", DefaultCar()))
        val racingGame = spyk(CompeteRacingGame(DefaultRacingGame(DefaultRandomGenerator(), cars)))
        val racingGameController = RacingGameController(racingGame)
        `when`("레이싱 게임을 하면") {
            racingGameController.doRacingGame(5)
            then("승자를 출력한다") {
                verify { racingGame.getWinner() }
            }
        }
    }
})
