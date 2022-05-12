package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `1) 자동차 개수 생성`(input: Int) {
        val cars = Cars.from(input)
        Assertions.assertThat(cars.carsList.size).isEqualTo(input)

    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `2) 자동차 개수 생성 후 실행(이동 성공)`(input: Int) {
        val cars = Cars.from(input)
        cars.run(object : MovingStrategy {
            override fun movable(): Boolean {
                return true
            }
        })
        for (i in 0 until input) {
            Assertions.assertThat(cars.carsList.get(i).position).isEqualTo(1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `3) 자동차 개수 생성 후 실행(이동 실패)`(input: Int) {
        val cars = Cars.from(input)
        cars.run(object : MovingStrategy {
            override fun movable(): Boolean {
                return false
            }
        })
        for (i in 0 until input) {
            Assertions.assertThat(cars.carsList.get(i).position).isEqualTo(0)
        }
    }
}
