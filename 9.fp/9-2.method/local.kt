package main.kotlin.fp.method

import main.java.reference.lec16.Person


// 지역함수
// 함수 안에 함수를 선언할 수 있다.

fun createPerson(firstName: String, lastName: String): Person {
    if (firstName.isEmpty()) {
        throw IllegalArgumentException("firstName 은 비어있을 수 없습니다. 현재 값 : ${firstName}")
    }

    if (lastName.isEmpty()) {
        throw IllegalArgumentException("secondName 은 비어있을 수 없습니다. 현재 값 : ${lastName}")

    }

    return Person(firstName, lastName, 10)
}


// 중복 코드를 제거하고 싶고
// 함수로 추출하면 좋을 것 같은데, 이 함수를 지금 함수 내에서만 사용하고 싶을 때
// 그치만, depth 가 깊어지기도 하고, 코드가 그렇게 깔끔하지는 않아서 거의 사용하지는 않는 듯
fun createPerson2(firstName: String, lastName: String): Person {
    if (firstName.isEmpty()) {
        throw IllegalArgumentException("firstName 은 비어있을 수 없습니다. 현재 값 : ${firstName}")
    }

    if (lastName.isEmpty()) {
        throw IllegalArgumentException("secondName 은 비어있을 수 없습니다. 현재 값 : ${lastName}")

    }

    fun validateName(name:String, fieldName: String) {
        if (name.isEmpty()) {
            IllegalArgumentException("${fieldName}은 비어있을 수 없습니다!  현재 값 : ${name}")
        }
    }

    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 10)
}


/*
함수 안에 함수를 선언할 수 있고 지역함수라고 칭함
 */