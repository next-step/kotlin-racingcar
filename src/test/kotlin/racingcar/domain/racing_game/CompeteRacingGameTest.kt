package racingcar.domain.racing_game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.model.CompeteCar
import racingcar.model.DefaultCar

class CompeteRacingGameTest : BehaviorSpec({
    given("레이싱게임에 소유자가 없는 차를 등록한다") {
        val noNameCars = listOf(DefaultCar(), DefaultCar())
        val racingGame = CompeteRacingGame(DefaultRacingGame(FakeTrueGenerator(), noNameCars))
        then("승자를 얻으려할때 오류를 반환한다") {
            shouldThrow<IllegalStateException> {
                racingGame.getWinner()
            }
        }
    }

    given("레이싱게임에 소유자가 있는 차를 등록후 레이싱을 한다") {
        val cars = listOf(CompeteCar("Kim", DefaultCar()), CompeteCar("Bang", DefaultCar()))
        val racingGame = CompeteRacingGame(DefaultRacingGame(FakeTrueGenerator(), cars))
        racingGame.race()
        then("승자를 반환한다") {
            racingGame.getWinner() shouldBe listOf("Kim", "Bang")
        }
    }
})
