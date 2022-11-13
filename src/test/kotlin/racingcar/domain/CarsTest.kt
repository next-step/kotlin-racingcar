package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.dto.RacingResultDTO

class CarsTest {

    @Test
    fun `자동차 이름 목록을 입력 받아 컬렉션 생성 - 성공`() {
        assertDoesNotThrow {
            Cars(CarNames("pobi,crong,honux"))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["raemerrr", ",crong,honux", "pobi,,honux", "pobi,crong,"])
    @EmptySource
    fun `자동차 이름 목록을 입력 받아 컬렉션 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            Cars(CarNames(input))
        }
    }

    @Test
    fun `우승자 출력`() {
        val cars = Cars(CarNames("pobi,crong,honux"))
        val winners = cars.winners()
        assertEquals(
            listOf(
                RacingResultDTO("pobi", 0),
                RacingResultDTO("crong", 0),
                RacingResultDTO("honux", 0)
            ),
            winners
        )
    }
}
