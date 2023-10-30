package step3.presentation

import step3.data.RacingCar
import step3.data.RacingCourse
import step3.domain.MoveCourse
import step3.domain.TryMoving
import step3.domain.VisualizeMoveCount

object ResultView {
    fun showResult(racingCars: List<RacingCar>, racingCourse: RacingCourse) {
        println("실행 결과")

        repeat(racingCourse.tryCount) {
            for (car in racingCars) {
                MoveCourse.moveCourse(car, TryMoving.isSuccessfullyMoved())
                showCarMove(car)
            }
            println()
        }
    }

    private fun showCarMove(car: RacingCar) {
        println(VisualizeMoveCount.visualizeMoveCount(car.moveCount))
    }
}
