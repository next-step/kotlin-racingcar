package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given("Car : 단일 차량의 여러 라운드 진행") {
        var round = 0
        val car = Car()
        `when`("첫번째 라운드에 4가 주어지면") {
            val roundResult: RoundResult = car.race(++round, 4)
            then("차량 전진 횟수가 1 증가한다.") {
                roundResult.round shouldBe round
                roundResult.moveStatus shouldBe MoveStatus.ACCELERATION
                car.acceleratedRoundCount() shouldBe 1
            }
        }
        `when`("두번째 라운드에 3이 주어지면") {
            val roundResult: RoundResult = car.race(++round, 3)
            then("차량의 전진 횟수는 증가하지 않는다.") {
                roundResult.round shouldBe round
                roundResult.moveStatus shouldBe MoveStatus.BREAK
                car.acceleratedRoundCount() shouldBe 1
            }
        }
        `when`("세번째 라운드에 6이 주어지면") {
            val roundResult: RoundResult = car.race(++round, 6)
            then("차량 전진 횟수가 1 증가한다.") {
                roundResult.round shouldBe round
                roundResult.moveStatus shouldBe MoveStatus.ACCELERATION
                car.acceleratedRoundCount() shouldBe 2
            }
        }
        `when`("레이스가 종료된 후") {
            then("세번의 라운드 동안 차량은 총 두번 전진 했다.") {
                car.playRoundCount() shouldBe 3
                car.acceleratedRoundCount() shouldBe 2
            }
        }
    }
})
