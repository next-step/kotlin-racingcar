package racing.model

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 컬렉션 테스트")
class CarsTest {

    @Test
    fun `위치값이 제일 큰 자동차가 우승자`() {
        // given
        val cars = Cars(
            listOf(
                Car.of("aiden", 3),
                Car.of("pobi", 1),
                Car.of("crong", 3),
                Car.of("honux", 0)
            )
        )

        // when
        val winners = cars.findWinners()

        // then
        assertAll(
            { assertEquals(winners[0].name(), "aiden") },
            { assertEquals(winners[1].name(), "crong") }
        )
    }
}
