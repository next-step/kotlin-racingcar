package step3.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import step3.car.printer.CarPrinter
import step3.car.printer.CarPrinterImpl
import step3.car.rule.CarMovementRule
import step3.turn.Turn
import step3.turn.TurnImpl
import step3.turn.TurnManager
import step3.turn.TurnManagerImpl
import java.io.ByteArrayOutputStream
import java.io.PrintStream

const val TOTOAL_CAR = 3
const val TOTAL_TURN = 3

class RacingCarGameTest {
    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
    }

    @Test
    fun `startRacing() 3대의 Car로 3번의 턴 무조건 진행하도록 실행`() {
        val cars: List<Car> = (0 until TOTOAL_CAR).map { CarImpl() }
        val rule: CarMovementRule = object : CarMovementRule {
            override val rule = { true }
        }
        val printer: CarPrinter = CarPrinterImpl()
        val turn: Turn = TurnImpl {
            cars.forEach {
                rule.moveCarByRule(it)
                printer.print(it)
            }
        }
        val turnManager: TurnManager = TurnManagerImpl(TOTAL_TURN, turn)
        RacingCarGame(turnManager).startRacing()
        cars.forEach {
            assertThat(it.distance).isEqualTo(TOTAL_TURN)
        }
        assertThat(turn.current).isEqualTo(TOTAL_TURN)
        assertThat(turnManager.isFinishOrProceed()).isTrue()
        assertThat(outContent.toString()).isEqualTo(
            "_\n_\n_\n\n" +
                "__\n__\n__\n\n" +
                "___\n___\n___\n\n"
        )
    }
}
