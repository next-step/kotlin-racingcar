package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차들을 생성할 수 있다`() {
        assertThatCode {
            val generator = CarsGenerator() { true }
            generator.generate("a,b,c,d,e")
        }.doesNotThrowAnyException()
    }

    @Test
    fun `자동차들의 이동경로를 문자열로 반환한다`() {
        val generator = CarsGenerator() { true }
        val cars = generator.generate("a,b,c,d,e")
        cars.move()
        assertThat(cars.getPathStrings())
            .containsExactly("a : --", "b : --", "c : --", "d : --", "e : --")
    }

    @Test
    fun `현재 위치가 가장 큰 자동차들이 우승자가 된다`() {
        val generator = CarsGenerator() { true }
        val cars = generator.generate("a,b,c,d,e")
        cars.move()
        assertThat(cars.getWinners().names.joinToString(","))
            .isEqualTo("a,b,c,d,e")
    }
}
