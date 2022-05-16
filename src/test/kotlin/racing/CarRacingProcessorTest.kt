package racing

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import racing.processor.CarRacingProcessor
import racing.reader.CarRacingReader
import racing.viewer.CarRacingViewer

@ExtendWith(MockKExtension::class)
class CarRacingProcessorTest {

    @MockK(relaxed = true)
    private lateinit var carRacingViewer: CarRacingViewer

    @MockK(relaxed = true)
    private lateinit var carRacingReader: CarRacingReader

    @InjectMockKs
    private lateinit var cut: CarRacingProcessor

    @Test
    fun `정해진 횟수만큼 게임을 수행한다`() {
        every { carRacingReader.readNumberOfCar() }.returns(2)
        every { carRacingReader.readNumberOfTry() }.returns(5)

        cut.play()

        verify(atLeast = 1) { carRacingViewer.showHowManyCars() }
        verify(atLeast = 1) { carRacingViewer.showHowManyTries() }
        verify(atLeast = 1) { carRacingReader.readNumberOfCar() }
        verify(atLeast = 1) { carRacingReader.readNumberOfTry() }
        verify(atLeast = 5) { carRacingViewer.showGameStatus(any()) }
    }
}
