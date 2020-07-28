package wk1_step3

// 모든 메소드가 companion object 일 경우 object 로 할 것
// object vs class
//  try {
//
//         CarRacing.CarRacingView.showFirstInstruction()
//         val numberOfCars = CarRacing.CarRacingView.checkInput(readLine()!!)
//         CarRacing.CarRacingView.showSecondInstruction()
//         val numberOfTrial = CarRacing.CarRacingView.checkInput(readLine()!!)
//
//         println()
//         for (i in 1..numberOfTrial) {
//             for (j: Int in 1..numberOfCars) {
//                 CarRacing.CarRacingView.showMovement(CarRacing.CarRacing.countOfMovement(numberOfCars))
//             }
//             println()
//         }
//     } catch (e: Exception) {
//         println(e.message)
//     }
object CarRacing {

    private fun moveOrStop(): Boolean {
        val number: Int = ((Math.random() * 10).toInt())
        return number > 3
    }

    fun countOfMovement(mCount: Int): Int {
        var result: Int = 0
        for (i in 1..mCount) {
            if (moveOrStop()) result++
        }
        return result
    }
}
