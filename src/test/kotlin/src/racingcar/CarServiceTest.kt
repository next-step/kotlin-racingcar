package src.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarServiceTest {

    @Test
    fun `랜덤 값이 4 이상이면 자동차들이 움직인다`() {
        val carNames = "test1,test2,test3"
        val execute = CarService(4).execute(carNames)
            .map { it.getMoveCount() }

        assertThat(listOf(1, 1, 1)).hasSameElementsAs(execute)
    }

    @Test
    fun `랜덤 값이 4 미만이면 자동차들이 정지한다`() {
        val carNames = "test1,test2,test3"
        val execute = CarService(0).execute(carNames)
            .map { it.getMoveCount() }

        assertThat(listOf(0, 0, 0)).hasSameElementsAs(execute)
    }
}
