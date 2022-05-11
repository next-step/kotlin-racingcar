package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest{
    @Test
    fun initCars() {
        val race = Race(5)
        assertThat(race.getCars().size == 5)
        race.getCars().forEach {
            assertThat(it.getDistance() == 1)
        }
    }

    @Test
    fun doRace() {
        val race = Race(5)
        race.doRace().forEach {
            assertThat(it.getDistance() == 1 || it.getDistance() == 2)
        }
    }
}