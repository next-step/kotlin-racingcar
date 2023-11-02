package study.racingcar.application

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class CarNamesTest {

    @Test
    @DisplayName("자동차 이름의 문자열을 입력 받았을때 / 유효한 문자열인지 검증하고 / 자동차 이름으로 된 배열을 반환한다.")
    fun getProperFormatCarNames() {
        // given
        val input = "car1,car2,car3"
        val carNames = CarNames(input)

        // when
        val actual = carNames.getProperFormatCarNames()

        // then
        assertEquals(listOf("car1", "car2", "car3").map { CarName(it) }, actual)
    }

    @Test
    @DisplayName("5자가 넘어가는 자동차 이름의 문자열을 입력 받았을때 / 예외를 반환한다.")
    fun `getProperFormatCarNames exception case1`() {
        // given
        val input = "carNameExceedsFive"

        // when
        // then
        assertThrows(IllegalArgumentException::class.java) { CarName(input) }
    }

    @Test
    @DisplayName("중복이 있는 자동차 이름을 입력받았을때 / 예외를 반환한다.")
    fun `getProperFormatCarNames exception case2`() {
        // given
        val input = "car1,car1"
        val carNames = CarNames(input)

        // when
        // then
        assertThrows(IllegalArgumentException::class.java) { carNames.getProperFormatCarNames() }
    }
}