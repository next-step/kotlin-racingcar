package racingcar.domain

class Round(val id: Int) {
    fun start(carGroup: CarGroup) {
        carGroup.move()
    }
}
