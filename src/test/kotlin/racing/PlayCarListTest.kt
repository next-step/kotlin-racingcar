package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PlayCarListTest {
    @Test
    fun `우승자 요청을 했을 때, position이 가장 큰 자동차 객체를 반환한다`() {
        // given : 객체를 생성한다.
        val car1 = Car("oyj_1", 0)
        val car2 = Car("oyj_2", 3)
        val car3 = Car("oyj_3", 3)
        val playCarList = PlayCarList(listOf(car1, car2, car3))

        // when : 우승자 요청을 했을 때
        val actual = playCarList.getWinners()

        // then : position이 가장 큰 자동차 객체를 반환한다
        val expect = listOf(Car("oyj_2", 3), Car("oyj_3", 3))
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `이동 여부에 대한 리스트를 받고, 이동을 요청했을 때, ture인 자동차만 이동한다`() {
        // given : 객체를 생성한다.
        val car1 = Car("oyj_1", 0)
        val car2 = Car("oyj_2", 3)
        val car3 = Car("oyj_3", 3)
        val playCarList = PlayCarList(listOf(car1, car2, car3))

        val moveList = listOf(true, true, false)

        // when : 이동 여부를 받아 이동을 요청했을 때
        playCarList.moveCars(moveList)

        // then : true인 자동차만 이동한다
        val expect = PlayCarList(listOf(Car("oyj_1", 1), Car("oyj_2", 4), Car("oyj_3", 3)))
        assertThat(playCarList).isEqualTo(expect)
    }
}
