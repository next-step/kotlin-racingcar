package racingcar.racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car.Companion.MOVE_THRESHOLD
import racingcar.domain.Car.Companion.START_POSITION
import racingcar.domain.Car.Companion.STEP
import racingcar.domain.RacingGameParam
import racingcar.util.Constant.MAX_GENERATED_NUMBER
import racingcar.util.Constant.MIN_GENERATED_NUMBER
import racingcar.util.OrderNumberGenerator

class RacingTest : BehaviorSpec({
    val carCount = 10
    val rounds = 10
    lateinit var target: RacingGame

    beforeEach {
        target = RacingGame(
            RacingGameParam(carCount, rounds),
            OrderNumberGenerator(*(MIN_GENERATED_NUMBER..MAX_GENERATED_NUMBER).toList().toIntArray())
        )
    }

    given("runRound 메소드") {
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                target.runRound()
                target.cars.forEachIndexed { index, car ->
                    car.getPosition() shouldBe if (index < MOVE_THRESHOLD) START_POSITION else START_POSITION + STEP
                }
            }
        }
    }

    given("start 메소드") {
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                target.start()
                target.cars.forEachIndexed { index, car ->
                    car.getPosition() shouldBe if (index < MOVE_THRESHOLD) START_POSITION else START_POSITION + STEP * rounds
                }
            }
        }
    }
})
