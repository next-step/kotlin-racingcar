package step3

import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarTest {

    @Test
    fun `start() 정상 동작 테스트`() {
        val givenData = InputView(2, 3)
        RacingCar().start(givenData)
    }

    @Test
    fun `사용자가 입력한 자동차 수 만큼 자동차 객체가 만들어지는 테스트`() {
        var carList = mutableListOf<Car>()

        // given
        val number = 4

        // when
        RacingCar().makeCarList(carList, number)

        // then
        assertThat(carList.size).isEqualTo(number)
    }

    @Test
    fun `전진 조건이 3일 때 move() 호출 시 이동하지 않았음을 확인하는 테스트`() {
        var carList = mutableListOf(Car(1, ""), Car(2, "--"))

        val racingCar = spy(RacingCar())

        whenever(racingCar.canIMove()).thenReturn(false)

        racingCar.move(carList)

        assertThat(carList[0].distance).isEqualTo("")
        assertThat(carList[1].distance).isEqualTo("--")
    }

    @Test
    fun `전진 조건이 7일 때 move() 호출 시 이동하였음을 확인하는 테스트`() {
        var carList = mutableListOf(Car(1, ""), Car(2, "--"))

        val racingCar = spy(RacingCar())

        whenever(racingCar.canIMove()).thenReturn(true)

        racingCar.move(carList)

        assertThat(carList[0].distance).isEqualTo("-")
        assertThat(carList[1].distance).isEqualTo("---")
    }
}
