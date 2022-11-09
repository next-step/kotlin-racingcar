package step3.domain

import io.kotest.core.spec.style.BehaviorSpec
import step3.model.Car
import step3.model.DefaultCar

class RacingGameTest : BehaviorSpec({
    given("레이싱 게임을 할 차를 등록한다") {
        val car = DefaultCar()
        val cars: List<Car> = listOf(car)
        val fakeRandomGenerator = FakeRandomGenerator()
        val racingGame = RacingGame(fakeRandomGenerator, cars)
        `when`("랜덤값이 유효하지 않다면") {
            fakeRandomGenerator.isValid = false
            // TODO racingGame.race()
            then("차가 전진하지 않는다") {}
        }
        `when`("랜덤값이 유효하면") {
            fakeRandomGenerator.isValid = true
            // TODO racingGame.race()
            then("차가 전진한다") {}
        }
    }
})
