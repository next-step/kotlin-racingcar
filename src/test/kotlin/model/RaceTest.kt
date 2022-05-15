package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    val names = listOf("test1", "test2", "test3")
    @Test
    fun initCars() {
        val race = Race(names)
        assertThat(race.getCars().size == 3)
        race.getCars().forEach {
            assertThat(it.getDistance() == 1)
        }
    }

    @Test
    fun doRace() {
        val race = Race(names)
        race.getCars().forEach {
            assertThat(it.getDistance() == 1)
            it.go()
            assertThat(it.getDistance() == 2)
        }
    }
}
