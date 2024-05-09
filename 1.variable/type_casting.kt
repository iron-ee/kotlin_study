package main.kotlin.variable

import main.java.reference.lec03.Person


fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {        // is => java 에서 instanceof 와 동일    => dart 에서 is 와 동일
//        val person = obj as Person      // as => java 에서 (Person) obj 와 동일    => dart 에서 as 와 동일
//        println(person.age)
        println(obj.age)
    }
}


fun printAgeIfPerson2(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
    println(person?.name ?: "hi")
}


// value is Type    -> value 가 Type 이면 true, 아니면 false
// value !is Type   -> value 가 Type 이 아니면 true, 맞으면 false

// value as Type    -> value 가 Type 이면 Type 으로 타입 캐스팅, 아니면 예외 및 에러 발생
// value as? Type   -> value 가 Type 이면 타입 캐스팅, value 가 null 이면 null, value 가 Type 이 아니면 null
// 그래서 as? 를 안전한 타입 형변환 이라고 생각하면 좋다.