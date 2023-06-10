package racingcar.racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Input
import racingcar.util.OrderNumberGenerator

class RacingTest : BehaviorSpec({
    given("runRound 메소드") {
        val sut = Racing(Input(10, 10), OrderNumberGenerator(*(0..9).toList().toIntArray()))
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                sut.runRound()
                sut.getCars().withIndex().forEach { (index, car) ->
                    car.getPosition() shouldBe if (index < 4) 1 else 2
                }
            }
        }
    }

    given("start 메소드") {
        val sut = Racing(Input(10, 10), OrderNumberGenerator(*(0..9).toList().toIntArray()))
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                sut.start()
                sut.getCars().withIndex().forEach { (index, car) ->
                    car.getPosition() shouldBe if (index < 4) 1 else 11
                }
            }
        }
    }
})
