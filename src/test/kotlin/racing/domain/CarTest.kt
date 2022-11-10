package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racing.domain.strategy.RandomMovingStrategy
import racing.view.GameOutputView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class CarTest {
    private val standardOut: PrintStream = System.out
    private val outputStreamCaptor: ByteArrayOutputStream = ByteArrayOutputStream()

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car(RandomMovingStrategy)
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun `자동차 최초 position은 0이다`() {
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `이동에 따른 마크 정상 출력`() {
        repeat(10) {
            car.move()
        }
        GameOutputView.printPositions(car)
        assertThat(GameOutputView.POSITION_MARK.repeat(car.position)).isEqualTo(outputStreamCaptor.toString().trim())
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }
}
