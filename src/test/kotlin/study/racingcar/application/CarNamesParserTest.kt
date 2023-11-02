package study.racingcar.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNamesParserTest {

    @Test
    fun `자동차 이름의 문자열을 입력 받았을때 유효한 문자열인지 검증하고 자동차 이름으로 된 배열을 반환한다`() {
        // given
        val input = "car1,car2,car3"
        val carNameParser = CarNameParser(input)

        // when
        val actual = carNameParser.getCarNames()

        // then
        // TODO-review : equals 테스트 코드 작성 자동생성을 위해 CarNaems 를 data class 로 선언했는데, 적절한 시도인가요? 아직 어떤 시점에 어떤 도구를 사용해야할지 감이 잘 안잡히네요..!
        assertEquals(listOf("car1", "car2", "car3").map { CarName(it) }.let { CarNames(it) }, actual)
    }

    @Test
    fun `중복이 있는 자동차 이름을 입력받았을때 CarNames 객체 선언시, 예외를 반환한다`() {
        // given
        val input = "car1,car1"

        // when
        // then
        assertThrows<IllegalArgumentException> { CarNameParser(input) }
    }

    @Test
    fun `5자가 넘어가는 자동차 이름의 문자열을 입력 받았을때 예외를 반환한다`() {
        // given
        val input = "carNameExceedsFive"

        // when
        // then
        assertThrows<IllegalArgumentException> { CarName(input) }
    }
}
