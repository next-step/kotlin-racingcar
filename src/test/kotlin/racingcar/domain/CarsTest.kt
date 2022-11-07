package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차 이름 목록을 입력 받아 컬렉션 생성`() {
        assertDoesNotThrow {
            Cars(CarNames("pobi,crong,honux"))
        }
    }

    @Test
    fun `레이싱 결과 확인`() {
        val cars = Cars(CarNames("pobi,crong,honux"))
        val racingResult = cars.racingResult()
        val carNames = racingResult.map { it.carName }.toList()
        val distances = racingResult.map { it.distance }.toList()
        assertThat(carNames).containsExactly("pobi", "crong", "honux")
        assertThat(distances).containsExactly(0, 0, 0)
    }

    @Test
    fun `우승자 확인`() {
        val cars = Cars(CarNames("pobi,crong,honux"))
        val racingResult = cars.winners()
        val carNames = racingResult.map { it.carName }.toList()
        assertThat(carNames).containsExactly("pobi", "crong", "honux")
    }
}
