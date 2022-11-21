package racingcar.view.store

import racingcar.domain.CarGroup

object CarGroupStore : Store<CarGroup> {
    private var carGroup = CarGroup(cars = listOf())

    override fun getState(): CarGroup {
        return carGroup
    }

    override fun setState(state: CarGroup) {
        carGroup = state
    }
}
