package camp.nextstep.edu.view

import camp.nextstep.edu.model.Car
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputHandlerTest {

    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun displayWinners_singleWinner() {
        val winners = listOf(Car("car", 5))
        OutputHandler.displayWinners(winners)
        assertEquals("우승자: car\n", outputStreamCaptor.toString())
    }

    @Test
    fun displayWinners_multipleWinners() {
        val winners = listOf(Car("car", 5), Car("jun", 5))
        OutputHandler.displayWinners(winners)
        assertEquals("우승자: car, jun\n", outputStreamCaptor.toString())
    }

    @Test
    fun displayWinners_noWinners() {
        val winners = emptyList<Car>()
        OutputHandler.displayWinners(winners)
        assertEquals("우승자가 없습니다.\n", outputStreamCaptor.toString())
    }

    @Test
    fun displayRoundResult_multiplePositions() {
        val positions = listOf("car : --", "jun : -", "crong : ---")
        OutputHandler.displayRoundResult(positions)
        assertEquals("car : --\njun : -\ncrong : ---\n\n", outputStreamCaptor.toString())
    }

    @Test
    fun displayRoundResult_emptyPositions() {
        val positions = emptyList<String>()
        OutputHandler.displayRoundResult(positions)
        assertEquals("\n", outputStreamCaptor.toString())
    }

    @Test
    fun displayRoundResult_singlePosition() {
        val positions = listOf("car : --")
        OutputHandler.displayRoundResult(positions)
        assertEquals("car : --\n\n", outputStreamCaptor.toString())
    }
}