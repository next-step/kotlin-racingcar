package domain

data class Person(val name: String, val age: Int, var nickname: String? = name)