package racing

import io.mockk.every
import io.mockk.mockkObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RacingTest {

    @ParameterizedTest
    @CsvSource(
        "0,0",
        "2,1",
        "2,1",
    )
    fun `자동차, Round 기준으로 2차원 Collection이 생성되는지 확인`(
        carCnt: Int, roundCnt: Int
    ) {
        val racing = Racing(carCount = carCnt, roundCount = roundCnt)
        val result = racing.game(
            roundList = roundCnt.toList(),
            carList = carCnt.toList(),
        )

        assertThat(result.size).isEqualTo(roundCnt)
        result.forEach { assertThat(it.size).isEqualTo(carCnt) }
    }


    @ParameterizedTest
    @CsvSource(
        "0,0",
        "2,1",
        "2,1",
    )
    fun `랜덤으로 생성된 distance 가 4보다 작으면 0으로 생성된 Collection`(
        carCnt: Int, roundCnt: Int
    ) {
        mockkObject(Distance)
        every { Distance.getRandom() } returns 3

        val racing = Racing(carCount = carCnt, roundCount = roundCnt)
        val result = racing.game(
            roundList = roundCnt.toList(),
            carList = carCnt.toList(),
        )

        result.forEach { it.forEach { car -> assertThat(car.distance).isEqualTo(0) } }
    }
}
