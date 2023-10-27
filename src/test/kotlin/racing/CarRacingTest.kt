package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarRacingTest {

    @ParameterizedTest
    @CsvSource("3, 5", "5, 5")
    fun `몇 대의 자동차로 몇 번의 이동을 할 것인지를 저장한 이차원 배열이 생성되는가`(carCount: Int, tryCount: Int) {
        assertThat(InputView.create(tryCount, carCount)).isEqualTo(List(tryCount) { List(carCount) { Car() } })
    }

    @Test
    fun `전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우인가`() {
        val random = CarRacing.random(0..9)
        assertThat(CarRacing.isMove { random }).isEqualTo(random >= 4)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `자동차가 이동한 횟수만큼 실행 결과인 '-'가 반복 되는가`(moveCount: Int) {
        val car = Car()
        assertThat(car.getResult()).isEqualTo("-")
        for (i in 0 until moveCount) {
            car.move()
        }
        assertThat(car.getResult()).isEqualTo("----")
    }
}
