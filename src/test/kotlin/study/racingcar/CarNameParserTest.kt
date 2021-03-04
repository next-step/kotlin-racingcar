package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingcar.domain.CarNameParser

internal class CarNameParserTest {

    @Test
    fun `쉼표의 개수에 +1 만큼 자동차가 생성된다`() {
        val count = "a,b".count { it == ',' }
        val cars = CarNameParser.requestParseCarNames("a,b")
        assertThat(cars.size).isEqualTo(count + 1)
    }
}
