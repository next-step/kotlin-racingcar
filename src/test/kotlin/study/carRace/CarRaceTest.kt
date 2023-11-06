package study.carRace

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream

class CarRaceTest {

    private val carRace = CarRace()
    private val inputView = InputView()
    private val resultView = ResultView()

    @Test
    fun `자동차 경주`() {
        val input = "3\n5\n"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val carQuality = inputView.carQuantity()
        val inningCount = inputView.inningCount()

        carRace.start(carQuality, inningCount)
    }

    @Test
    fun `전진하는 조건1`() {
        assertThat(resultView.moveOrStop(3)).isEqualTo(null)
    }

    @Test
    fun `전진하는 조건2`() {
        assertThat(resultView.moveOrStop(5)).isEqualTo("-")
    }

    @Test
    fun `자동차 n대 생성`() {
        carRace.initCars(3)

        assertThat(carRace.getCars().size).isEqualTo(3)
    }

    @Test
    fun `시도할 횟수`() {
        val input = "0"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            inputView.inningCount()
        }
    }

    @Test
    fun `자동차 대수`() {
        val input = "0"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            inputView.carQuantity()
        }
    }
}
