package study.racing.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import racing.domain.car.Car
import racing.domain.car.CarManager
import study.racing.rule.FakeRule

class CarManagerTest {
    private val rule = FakeRule()
    private val carManager = CarManager(rule)

    // 검증
    // - 이름 5자 미만
    // - 차동차 이름 공백
    // - 출전 차량 0대
    @ParameterizedTest
    @MethodSource("validateInputTestData")
    fun `잘못된 이름으로 차량을 생성하고, 검증 로직을 동작할 때, 오류를 발생시킨다`(carNames: String, expected: Exception) {
        // given: 잘못된 이름으로 차량을 생성한다.
        carManager.createCarList(carNames)

        // when : 검증 로직은 실행한다.
        val actual = runCatching { carManager.validateCarList() }.exceptionOrNull()

        // then : 오류가 발생한다
        assertThat(actual).isInstanceOf(expected::class.java)
    }

    // 이름 분리
    // 차량 생성
    @Test
    fun `사용자가 차량 이름을 나열하여 입력하면, createCarList()을 호출하면, 차량이 콤마를 기준으로 이름만큼 생성된다`() {
        // given : 차량 이름을 나열
        val carNames = "car,boy,gang"
        val carList = listOf(Car("car"), Car("boy"), Car("gang"))

        // when : createCarList()를 호출하여 분류
        carManager.createCarList(carNames)
        val actual = carManager.getCarList()
        // then : 콤마를 기준으로 나눠졌나 확인
        assertThat(actual).isEqualTo(carList)
    }

    // 차 이동(규칙: 모든 차 이동)
    @Test
    fun `사용자가 자동차를 생성하고, isMove()를 호출한다면, 차량의 포지션이 1 증가한다`() {
        // given : 차량 이름을 나열한 문자열을 기반으로 자동차 생성
        val carNames = "car,boy,gang"
        carManager.createCarList(carNames)

        // when : isMove() 호출
        carManager.moveCar()

        // then : 차량의 포지션이 2가 된다.(초기 포지션은 1)
        carManager.getCarList().forEach {
            assertThat(it.position).isEqualTo(2)
        }
    }

    companion object {
        @JvmStatic
        fun validateInputTestData() = listOf(
            arrayOf("lightSpeed, light, bush", IllegalArgumentException()),
            arrayOf("  , light, bush", IllegalArgumentException())
        )
    }
}
