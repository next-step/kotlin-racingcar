package step3.presentation

fun main(){
    val racingCars = InputView.enterCarNumber()
    val racingCourse = InputView.enterTryCount()
    ResultView.showResult(racingCars, racingCourse)
}
