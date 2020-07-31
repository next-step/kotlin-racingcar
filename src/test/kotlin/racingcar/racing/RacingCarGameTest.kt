package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.racing.car.Car
import racingcar.racing.const.GAME_RESULT
import racingcar.racing.printer.CarNamePrinter
import racingcar.racing.printer.CarPrinter
import racingcar.racing.printer.ResultPrinter
import racingcar.racing.rule.CarMovementRule
import racingcar.racing.view.MockUpView
import racingcar.turn.Turn
import racingcar.turn.TurnManager
import racingcar.turn.SimpleTurnManager

const val TOTAL_CAR = 3
const val TOTAL_TURN = 3

class RacingCarGameTest {
    @Test
    fun `startRacing() 3대의 Car로 3번의 턴 무조건 진행하면 자동차가 3칸씩 진행`() {
        val view = MockUpView()
        val rule: CarMovementRule = object : CarMovementRule {
            override val rule = { true }
        }
        val cars: List<Car> = (0 until TOTAL_CAR).map { Car("$it") }
        val turn: Turn = Turn(cars = cars, rule = rule)
        val turnManager: TurnManager = SimpleTurnManager(TOTAL_TURN, turn)

        val result = RacingCarGame(turnManager).startRacing()
        println(view.toString())
        result.turns.last().cars.forEach {
            assertThat(it.distance).isEqualTo(TOTAL_TURN)
        }
    }

    @Test
    fun `startRacing() 3대의 Car로 3번의 턴 무조건 진행하면 최종 턴이 3턴`() {
        val view = MockUpView()
        val rule: CarMovementRule = object : CarMovementRule {
            override val rule = { true }
        }
        val cars: List<Car> = (0 until TOTAL_CAR).map { Car("$it") }
        val turn: Turn = Turn(cars = cars, rule = rule)
        val turnManager = SimpleTurnManager(TOTAL_TURN, turn)

        RacingCarGame(turnManager).startRacing()

        assertThat(turnManager.lastResult.current).isEqualTo(TOTAL_TURN)
        assertThat(turnManager.isFinishOrProceed()).isNull()
    }

    @Test
    fun `startRacing() 3대의 Car로 3번의 턴 무조건 진행했을 때 출력결과 비교`() {
        val view = MockUpView()
        val rule: CarMovementRule = object : CarMovementRule {
            override val rule = { true }
        }
        val printer: CarPrinter = CarNamePrinter(view)

        val cars: List<Car> = (0 until TOTAL_CAR).map { Car("$it") }
        val turn: Turn = Turn(cars = cars, rule = rule)
        val turnManager: TurnManager = SimpleTurnManager(TOTAL_TURN, turn)

        val result = RacingCarGame(turnManager).startRacing()
        ResultPrinter(printer, result.turns, view).print()

        assertThat(view.toString()).isEqualTo(
            "\n$GAME_RESULT\n" +
                "0 : _\n1 : _\n2 : _\n\n" +
                "0 : __\n1 : __\n2 : __\n\n" +
                "0 : ___\n1 : ___\n2 : ___\n\n"
        )
    }
}
