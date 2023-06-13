package step3.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.UUID
import kotlin.random.Random

internal class RaceConditionTest {
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
                "jeff",
                Random.nextInt(Int.MIN_VALUE, 0).toString(),
            )
        }
    }

    @Test
    fun `if value is longer than 5 letters then throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            RaceCondition.of(
                "jeff",
                Random.nextInt(Int.MIN_VALUE, 0).toString(),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("makeRaceCondition")
    fun `if value is number of string then make race condition`(nameOfCars: String, numberOfLabs: String) {
        val raceCondition = RaceCondition.of(nameOfCars, numberOfLabs)
        assertEquals(nameOfCars, raceCondition.nameOfCars[0])
        assertEquals(numberOfLabs.toInt(), raceCondition.numberOfLabs)
    }

    @ParameterizedTest
    @ValueSource(strings = ["jeff,hoodi,clo,champ,binar,keith", "hi,hello,my,name,is"])
    fun `string split test`(names: String) {
        val raceCondition = RaceCondition.of(names, "4")
        names.split(",").forEachIndexed { index, name ->
            assertEquals(name, raceCondition.nameOfCars[index])
        }
    }

    companion object {
        @JvmStatic
        fun makeRaceCondition(): List<Arguments> {
            return (0..20).map {
                Arguments.of(
                    UUID.randomUUID().toString().substring(0, 5),
                    Random.nextInt(1, Int.MAX_VALUE).toString(),
                )
            }
        }
    }
}
