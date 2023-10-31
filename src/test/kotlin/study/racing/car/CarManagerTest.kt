package study.racing.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import racing.car.CarManager

class CarManagerTest {

    // 자동차 생성
    // 자동차 이동
    @Test
    fun `CarManager의createCarList(num)을 요청하면 ,position이 1인 출전 차량이 num만큼의 생성된다`() {
        // when : 4대의 차량 생성을 요청한다.
        val carManager = CarManager()
        carManager.createCarList(4)

        // then : position이 1인 4대의 차량이 생성된다.
        val expect = listOf(1, 1, 1, 1)

        assertThat(carManager.getCarPositionList()).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("validateInputTestData")
    fun `carManager를 생성하고, 검증 로직에 잘못된 입력값을 넣었을 때, 오류를 발생시킨다`(carCnt: String, expected: Exception) {
        // given: carManager를 생성한다.
        val carManager = CarManager()

        // when : 검증로직에 잘못된 입력값을 넣는다.
        val actual = runCatching { carManager.validateInputData(carCnt) }.exceptionOrNull()

        // then : 오류가 발생한다
        assertThat(actual).isInstanceOf(expected::class.java)
    }

    companion object {
        @JvmStatic
        fun validateInputTestData() = listOf(
            arrayOf("", IllegalArgumentException()),
            arrayOf("d", NumberFormatException()),
            arrayOf("0", IllegalArgumentException()),
        )
    }
}
