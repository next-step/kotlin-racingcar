package carracing.game.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class CarRacingModelTest {
    private lateinit var model: CarRacingModel

    @BeforeEach
    fun initModel() {
        model = CarRacingModel()
    }

    @Test
    fun `when assignCars has valid input should assign successfully`() {
        listOf("c1,c2", "c1,c2,c3").forEach {
            shouldNotThrowAny { model.assignCars(it) }
        }
    }

    @Test
    fun `when assignCars has invalid input should return false`() {
        listOf("c1:c2", null).forEach {
            val e = shouldThrowExactly<IllegalArgumentException> { model.assignCars(it) }
            e.message shouldBe "Cars amount should be at least $MIN_CARS_AMOUNT"
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2"])
    fun `when assignRoundsAmount has valid input should assign successfully`(input: String) {
        shouldNotThrowAny { model.assignRoundsAmount(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "abc"])
    @NullSource
    fun `when assignRoundsAmount has invalid input should return false`(input: String?) {
        val e = shouldThrowExactly<IllegalArgumentException> { model.assignRoundsAmount(input) }
        e.message shouldBe "Rounds amount should be at least $MIN_ROUNDS_AMOUNT"
    }

    @Test
    fun `when rounds are not set getRaceSequence should throw exception`() {
        model.assignCars("c1, c2")
        shouldThrowExactly<IllegalStateException> { model.getRaceSequence() }
    }

    @Test
    fun `when cars are not set getRaceSequence should throw exception`() {
        model.assignRoundsAmount("3")
        shouldThrowExactly<IllegalStateException> { model.getRaceSequence() }
    }

    @Test
    fun `getRaceSequence should emit correct number of race updates`() =
        runTest {
            model.assignCars("c1,c2,c3")
            model.assignRoundsAmount("5")

            val sequence = model.getRaceSequence()
            val races = sequence.toList()

            races.size shouldBe 5
            races.last().round shouldBe 5
            races.forEach {
                it.cars.size shouldBe 3
            }
        }
}
