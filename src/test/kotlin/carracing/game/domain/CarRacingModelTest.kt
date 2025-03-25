package carracing.game.domain

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.random.Random

class CarRacingModelTest {
    private val random = mock<Random>()
    private lateinit var model: CarRacingModel

    @BeforeEach
    fun initModel() {
        whenever(random.nextBoolean()).thenReturn(true)
        model = CarRacingModel(random)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2", "3"])
    fun `when assignCarsAmount has valid input should return true`(input: String) {
        assertThat(model.assignCarsAmount(input)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "1", "abc"])
    @NullSource
    fun `when assignCarsAmount has invalid input should return false`(input: String?) {
        assertThat(model.assignCarsAmount(input)).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2"])
    fun `when assignRoundsAmount has valid input should return true`(input: String) {
        assertThat(model.assignRoundsAmount(input)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "abc"])
    @NullSource
    fun `when assignRoundsAmount has invalid input should return false`(input: String?) {
        assertThat(model.assignRoundsAmount(input)).isFalse()
    }

    @Test
    fun `when cars are not set getRaceFlow should throw exception`() {
        model.assignCarsAmount("3")
        assertThrows<IllegalArgumentException> { model.getRaceFlow() }
    }

    @Test
    fun `when rounds are not set getRaceFlow should throw exception`() {
        model.assignRoundsAmount("3")
        assertThrows<IllegalArgumentException> { model.getRaceFlow() }
    }

    @Test
    fun `getRaceFlow should emit correct number of race updates`() =
        runTest {
            model.assignCarsAmount("3")
            model.assignRoundsAmount("5")

            val flow = model.getRaceFlow()
            val races = flow.toList()

            assertThat(races.size).isEqualTo(5)
            assertThat(races.first().round).isEqualTo(1)
            races.forEach {
                assertThat(it.cars.size).isEqualTo(3)
            }
        }

    @Test
    fun `when random is true getRaceFlow should update cars positions`() =
        runTest {
            model.assignCarsAmount("3")
            model.assignRoundsAmount("5")

            val flow = model.getRaceFlow()
            val races = flow.toList()

            races.last().cars.forEach {
                assertThat(it.position).isEqualTo(6)
            }
        }
}
