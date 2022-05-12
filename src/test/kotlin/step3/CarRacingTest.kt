package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarRacingTest {
    @ParameterizedTest
    @CsvSource("3, 5",
        "4, 5",
        "3, 2")
    fun `1) 자동차 개수 생성 및 무조건 이동시 위치 테스트`(carCount: Int, moveCount: Int) {
        val carRacing = CarRacing.of(carCount, moveCount)
        carRacing.run(object : MovingStrategy {
            override fun movable(): Boolean {
                return true
            }
        })
        for (i in 0 until carCount) {
            Assertions.assertThat(carRacing.cars.carsList.get(i).position).isEqualTo(moveCount)
        }
    }

    @ParameterizedTest
    @CsvSource("3, 5",
        "4, 5",
        "3, 2")
    fun `2) 자동차 개수 생성 및 MovingStrategyRandom 클래스 반영 테스트`(carCount: Int, moveCount: Int) {
        val carRacing = CarRacing.of(carCount, moveCount)
        carRacing.run(MovingStrategyRandom())
        Assertions.assertThat(carRacing.cars.carsList.size).isEqualTo(carCount)
    }
}
