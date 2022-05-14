import org.junit.jupiter.api.Test

class CarRacingOutputHandlerTest {

    @Test
    fun `car object 내 move의 카운트 만큼 진행상태를 기록한다`() {
        var car1 = Car("자동차1")
        var car2 = Car("자동차2")
        var car3 = Car("자동차3")
        val cars = listOf(car1, car2, car3)

        repeat(2) {
            car1.move()
            car2.move()
            car3.move()
        }
        repeat(1) {
            car1.stop()
            car2.move()
            car3.move()
        }

        CarRacingOutputHandler.display(cars)
    }
}
