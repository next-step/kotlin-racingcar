package racingcar.store

import racingcar.CarGroup

object CarGroupStore : Store<CarGroup> {
    private var carGroup = CarGroup(cars = listOf())

    override fun getState(): CarGroup {
        return this.carGroup
    }

    override fun setState(state: CarGroup) {
        this.carGroup = state
    }
}
