import org.junit.jupiter.api.Test

class CarRacingOutputHandlerTest {

    @Test
    fun `car object 내 move의 카운트 만큼 진행상태를 기록한다`() {
        var car1 = Car()

        repeat(2) {
            car1.move()
        }
        repeat(1) {
            car1.stop()
        }

        val cars = listOf(car1)
        CarRacingOutputHandler.display(cars)
    }
}
