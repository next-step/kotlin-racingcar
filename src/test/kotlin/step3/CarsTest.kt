package step3

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@ExtendWith(MockKExtension::class)
internal class CarsTest {

    @MockK
    lateinit var movingStrategy: MovingStrategy

    @ParameterizedTest
    @CsvSource("jay,kevin,evan/ 3",
        "jay,kevin,evan,emma/ 4",
        delimiter = '/')
    fun `1) 자동차 이름 5자 초과하지 않는 경우 정상처리 테스트`(carNames: String, result: Int) {
        val cars = Cars.from(carNames)
        Assertions.assertThat(cars.carsList.size).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("jay,kevin,evan,audrey",
        "jay,kevin,evan,emma,carName",
        delimiter = '/')
    fun `2) 자동차 이름 5자 초과하는 경우 예외처리 테스트`(carNames: String) {
        Assertions.assertThatThrownBy { Cars.from(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.")
    }

    @ParameterizedTest
    @CsvSource("jay,kevin,evan/ 3",
        "jay,kevin,evan,emma/ 4",
        delimiter = '/')
    fun `3) 자동차 개수 생성 후 실행(이동 성공)`(carNames: String, result: Int) {
        val cars = Cars.from(carNames)
        every { movingStrategy.movable() } returns true
        cars.run(movingStrategy)
        for (i in 0 until cars.carsList.size) {
            Assertions.assertThat(cars.carsList[i].getPosition()).isEqualTo(1)
        }
        Assertions.assertThat(cars.carsList.size).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("jay,kevin,evan/ 3",
        "jay,kevin,evan,emma/ 4",
        delimiter = '/')
    fun `4) 자동차 개수 생성 후 실행(이동 실패)`(carNames: String, result: Int) {
        val cars = Cars.from(carNames)
        every { movingStrategy.movable() } returns false
        cars.run(movingStrategy)
        for (i in 0 until cars.carsList.size) {
            Assertions.assertThat(cars.carsList[i].getPosition()).isEqualTo(0)
        }
        Assertions.assertThat(cars.carsList.size).isEqualTo(result)
    }
}

