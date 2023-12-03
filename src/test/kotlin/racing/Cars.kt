package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Cars {
    @Test
    fun `우승자 요청을 했을 때, position이 가장 큰 자동차 객체를 반환한다`() {
        // given : 객체를 생성한다.
        val car1 = Car2("oyj_1", 0)
        val car2 = Car2("oyj_2", 3)
        val car3 = Car2("oyj_3", 3)
        val cars = Cars2(listOf(car1, car2, car3))

        // when :
        val actual= cars.getWinners()

        // then :
        val expect = listOf(Car2("oyj_2", 3), Car2("oyj_3", 3))
        assertThat(actual).isEqualTo(expect)
    }
}
