package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StatisticsTest {
    @Test
    fun `Winner 구하기 테스트`() {
        // given
        val listOf = listOf(
            Car("one", 1),
            Car("two", 2),
            Car("three", 3),
            Car("four", 4)
        )
        val cars = Cars(listOf)

        // when
        Statistics.exec(cars)

        // then
        val expected = Car("et", 4)
        assertEquals(expected.status, 4)
    }
}