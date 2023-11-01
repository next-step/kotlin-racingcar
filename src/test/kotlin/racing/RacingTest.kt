package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingTest {
    @Test
    fun `레이싱 준비 init() 함수 테스트 `() {
        val race = Racing(3, 5)
        Assertions.assertThat(race.carList.size).isEqualTo(3)
    }

    @Test
    fun `레이싱 시작 goRacing() 함수 테스트`() {
        val race = Racing(2, 3)
        race.goRacing()
        val result = arrayOf("-", "--", "---", "")
        Assertions.assertThat(race.carList[0].getRoute()).isIn(*result)
    }
}
