package racingcar.domain.racing_game

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import racingcar.model.Car
import racingcar.model.DefaultCar

class DefaultRacingGameTest : BehaviorSpec({
    given("레이싱 게임을 할 차를 등록한다") {
        val car = DefaultCar()
        val cars: List<Car> = listOf(car)
        `when`("랜덤값이 유효하지 않다면") {
            val racingGame = DefaultRacingGame(FakeFalseGenerator(), cars)
            racingGame.race()
            then("차가 전진하지 않는다") {
                racingGame.cars.forEach { car ->
                    car.track.shouldBeEmpty()
                }
            }
        }
        `when`("랜덤값이 유효하면") {
            val racingGame = DefaultRacingGame(FakeTrueGenerator(), cars)
            racingGame.race()
            then("차가 전진한다") {
                racingGame.cars.forEach { car ->
                    car.track shouldBe "-"
                }
            }
        }
    }
})
