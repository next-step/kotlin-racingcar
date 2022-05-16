package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    val names = listOf("test1", "test2", "test3")
    @Test
    fun doRace() {
        val race = Race(names)
        race.doRace()
        assertThat(race.getRecords().size == 1)
    }
}
