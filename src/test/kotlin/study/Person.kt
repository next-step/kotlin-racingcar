package study

data class Person(val name: String, val age: Int, val nickname: String? = name) // 단 디폴트는 앞선 프로퍼티가 있어야 한다.
