package step3.view

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step3.entity.RacingCar
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.UUID
import kotlin.random.Random

internal class OutputViewTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun teardown() {
        System.setOut(standardOut)
    }

    @ParameterizedTest
    @ValueSource(strings = ["*", "-", "234", "54"])
    fun `test output exact number of line symbols`(lineSymbol: String) {
        val outputView = OutputView(lineSymbol)
        val racingCars = listOf(
            RacingCar(UUID.randomUUID().toString(), Random.nextInt(0, 100)),
            RacingCar(UUID.randomUUID().toString(), Random.nextInt(0, 100)),
            RacingCar(UUID.randomUUID().toString(), Random.nextInt(0, 100)),
        )
        var expected = ""
        racingCars.forEach {
            expected += "${lineSymbol.repeat(it.position)}\n"
        }
        outputView.forLabs(racingCars)
        assertEquals(expected.dropLast(1), outputStreamCaptor.toString().trim())
    }
}
