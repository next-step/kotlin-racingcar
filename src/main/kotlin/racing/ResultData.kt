package racing

class ResultData {

    private val _resultDataList =  mutableListOf<PlayCarList>()
    val resultDataList: List<PlayCarList>
        get() = _resultDataList.toList()

    fun saveResultData(playCarList: PlayCarList) {

        val copiedCarList = PlayCarList(playCarList.carList.map { it.copy() })
        _resultDataList.add(copiedCarList)
    }
}
