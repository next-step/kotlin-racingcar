// 모든 메소드가 companion object 일 경우 object 로 할 것
// object vs class
//  try {
//
//         CarRacingView.showFirstInstruction()
//         val numberOfCars = CarRacingView.checkInput(readLine()!!)
//         CarRacingView.showSecondInstruction()
//         val numberOfTrial = CarRacingView.checkInput(readLine()!!)
//
//         println()
//         for (i in 1..numberOfTrial) {
//             for (j: Int in 1..numberOfCars) {
//                 CarRacingView.showMovement(CarRacing.countOfMovement(numberOfCars))
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
