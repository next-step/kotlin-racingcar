package step3.domain.car

class RacingCarDataSet {

    companion object {
        fun testData(): RacingCar = RacingCar()

        fun testData(name: String) = RacingCar(name)

    }
}
