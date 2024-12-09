package racing.controller

import racing.domain.CarModel

interface MakeEntryInterface<T> {
    fun makeEntry(): List<T>
}

class MakeEntryCars(private val names: String, private val controller: GameUserInputInterface) :
    MakeEntryInterface<CarModel> {
    override fun makeEntry(): List<CarModel> {
        return names.split(DEFAULT_DELIMITER)
            .map {
                CarModel(inputName = it, controller = controller)
            }
    }

    companion object {
        const val DEFAULT_DELIMITER = ","
    }
}
