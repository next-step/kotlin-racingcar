package car_race.logic.car

import car_race.logic.system.MovingSystem
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject

/**
 * @see CarPosition
 */
class CarPositionTest : FunSpec({

    mockkObject(MovingSystem)

    context("CarPosition 단위 테스트") {
        val defaultPosition = 0
        val defaultCarPosition = CarPosition(defaultPosition)

        test("fun getValue(): 현재 위치를 반환한다.") {
            val position = shouldNotThrowAny {
                defaultCarPosition.getValue()
            }

            position shouldBe defaultPosition
        }

        for (randomNum in 0..3) {
            test("fun nextRound(): 랜덤 값 4 이하 일 경우 위치가 그대로이다.") {
                every { MovingSystem.rollDice() } returns randomNum

                defaultCarPosition.nextRound()

                defaultCarPosition.getValue() shouldBe defaultPosition
            }
        }

        for (randomNum in 4..9) {
            test("fun nextRound(): 랜덤 값 4 이상 일 경우 위치가 1 증가한다.") {
                every { MovingSystem.rollDice() } returns randomNum

                defaultCarPosition.nextRound()

                defaultCarPosition.getValue() shouldBe defaultPosition + 1
            }
        }
    }
})
