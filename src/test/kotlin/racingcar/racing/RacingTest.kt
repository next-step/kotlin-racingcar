package racingcar.racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car.Companion.MOVE_THRESHOLD
import racingcar.domain.Car.Companion.START_POSITION
import racingcar.domain.Car.Companion.STEP
import racingcar.domain.Input
import racingcar.util.NumberGenerator.Companion.MAX_GENERATED_NUMBER
import racingcar.util.NumberGenerator.Companion.MIN_GENERATED_NUMBER
import racingcar.util.OrderNumberGenerator

class RacingTest : BehaviorSpec({
    val carCount = 10
    val rounds = 10
    lateinit var sut: Racing
    beforeEach {
        sut = Racing(
            Input(carCount, rounds),
            OrderNumberGenerator(*(MIN_GENERATED_NUMBER..MAX_GENERATED_NUMBER).toList().toIntArray())
        )
    }

    given("runRound 메소드") {
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                sut.runRound()
                sut.getCars().withIndex().forEach { (index, car) ->
                    car.getPosition() shouldBe if (index < MOVE_THRESHOLD) START_POSITION else START_POSITION + STEP
                }
            }
        }
    }

    given("start 메소드") {
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                sut.start()
                sut.getCars().withIndex().forEach { (index, car) ->
                    car.getPosition() shouldBe if (index < MOVE_THRESHOLD) START_POSITION else START_POSITION + STEP * rounds
                }
            }
        }
    }
})
