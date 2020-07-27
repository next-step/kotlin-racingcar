import java.lang.NullPointerException

class CarRacing {
    companion object {

        fun execute(mCars: String?, mCount: String?) {
            try {
                val cars = CarRacingInputView.checkInput(mCars)
                val count: Int = CarRacingInputView.checkInput(mCount)

                for (i in 1..count) {
                    for (j in 1..cars) {
                        CarRacingResultView.showMovement(cars)
                    }
                    println()
                }
            } catch (e: NullPointerException) {
                throw NullPointerException("값을 입력해주세요.")
            }
        }
    }
}
