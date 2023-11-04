package study.racingcar.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import study.racingcar.domain.FourOrMoreGameRule
import study.racingcar.domain.WinGameRule
import study.racingcar.dto.CarName
import study.racingcar.dto.RacingCar.Companion.DEFAULT_POSITION
import study.racingcar.dto.CarNames
import study.racingcar.dto.RacingCars

class CarNamesTest {

    // TODO : 이게 요구사항에 있는 테스트 일까? ... TDD 에 맞는 접근일까? ... 단지 객체가 변환하는걸 테스트하기 위함인데, 이게 맞는걸까?
    @Test
    fun `CarNames 로 RacingCars 를 생성했을때, 현재 승자를 구해보면, 모두 같은 position 을 갖고 있다`() {
        // given
        val carNames = CarNames(listOf(CarName("car1"), CarName("car2"), CarName("car3")))
        val winGameRule = WinGameRule()

        // when
        val actual = carNames.prepareForRace(winGameRule)
        val currentWinners = actual.currentWinners

        // then
        assertEquals(RacingCars(currentWinners), actual)
    }
}
