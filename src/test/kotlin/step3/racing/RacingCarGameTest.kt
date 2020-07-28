package step3.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.racing.car.Car
import step3.racing.car.CarImpl
import step3.racing.const.GAME_RESULT
import step3.racing.printer.CarPrinter
import step3.racing.printer.CarPrinterImpl
import step3.racing.rule.CarMovementRule
import step3.racing.mock.MockUpView
import step3.turn.Turn
import step3.turn.TurnImpl
import step3.turn.TurnManager
import step3.turn.TurnManagerImpl

const val TOTOAL_CAR = 3
const val TOTAL_TURN = 3

class RacingCarGameTest {
    @Test
    fun `startRacing() 3대의 Car로 3번의 턴 무조건 진행하면 자동차가 3칸씩 진행`() {
        val view = MockUpView()
        val rule: CarMovementRule = object : CarMovementRule {
            override val rule = { true }
        }
        val printer: CarPrinter = CarPrinterImpl(view)

        val cars: List<Car> = (0 until 3).map { CarImpl() }
        val turn: Turn = TurnImpl.create(cars, rule, printer)
        val turnManager: TurnManager = TurnManagerImpl(3, turn)

        RacingCarGame(view, turnManager).startRacing()
        cars.forEach {
            assertThat(it.distance).isEqualTo(TOTAL_TURN)
        }
    }

    @Test
    fun `startRacing() 3대의 Car로 3번의 턴 무조건 진행하면 최종 턴이 3턴`() {
        val view = MockUpView()
        val rule: CarMovementRule = object : CarMovementRule {
            override val rule = { true }
        }
        val printer: CarPrinter = CarPrinterImpl(view)

        val cars: List<Car> = (0 until 3).map { CarImpl() }
        val turn: Turn = TurnImpl.create(cars, rule, printer)
        val turnManager: TurnManager = TurnManagerImpl(3, turn)

        RacingCarGame(view, turnManager).startRacing()

        assertThat(turn.current).isEqualTo(TOTAL_TURN)
        assertThat(turnManager.isFinishOrProceed()).isTrue()
    }

    @Test
    fun `startRacing() 3대의 Car로 3번의 턴 무조건 진행했을 때 출력결과 비교`() {
        val view = MockUpView()
        val rule: CarMovementRule = object : CarMovementRule {
            override val rule = { true }
        }
        val printer: CarPrinter = CarPrinterImpl(view)

        val cars: List<Car> = (0 until 3).map { CarImpl() }
        val turn: Turn = TurnImpl.create(cars, rule, printer)
        val turnManager: TurnManager = TurnManagerImpl(3, turn)

        RacingCarGame(view, turnManager).startRacing()

        assertThat(view.toString()).isEqualTo(
            "\n$GAME_RESULT\n" +
                "_\n_\n_\n\n" +
                "__\n__\n__\n\n" +
                "___\n___\n___\n\n"
        )
    }
}
