package step3.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.UUID
import kotlin.random.Random

internal class RaceConditionTest {
    @Test
    fun `if value is null then throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> { RaceCondition.of(null, null) }
    }

    @Test
    fun `if value is empty string then throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> { RaceCondition.of("", "") }
    }

    @Test
    fun `if value is string then throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            RaceCondition.of(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
            )
        }
    }

    @Test
    fun `if value is minus number then throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            RaceCondition.of(
                Random.nextInt(Int.MIN_VALUE, 0).toString(),
                Random.nextInt(Int.MIN_VALUE, 0).toString(),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("makeRaceCondition")
    fun `if value is number of string then make race condition`(numberOfCars: String, numberOfLabs: String) {
        val raceCondition = RaceCondition.of(numberOfCars, numberOfLabs)
        assertEquals(numberOfCars.toInt(), raceCondition.numberOfCars)
        assertEquals(numberOfLabs.toInt(), raceCondition.numberOfLabs)
    }

    companion object {
        @JvmStatic
        fun makeRaceCondition(): List<Arguments> {
            return (0..20).map {
                Arguments.of(
                    Random.nextInt(1, Int.MAX_VALUE).toString(),
                    Random.nextInt(1, Int.MAX_VALUE).toString(),
                )
            }
        }
    }
}
