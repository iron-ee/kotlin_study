package main.kotlin.oop.class_constructor

// 프로퍼티 = 필드 + getter + setter
// java 와 다르게 kotlin 에서는 getter, setter 를 자동으로 만들어줌.
class Person constructor(name: String, age: Int) {

    val name = String
    var age = Int

}

class Person2 (     // constructor 생략 가능, 클래스의 필드 선언과 생성자를 동시에 선언할 수도 있다.
    val name: String,
    var age: Int
)

fun classProperty() {
    val person = Person2("아무개", 100)
    println(person.name)    // .필드를 통해 getter, setter 를 바로 호출한다.
    person.age = 10         // java 클래스에 대해서도 .필드로 getter, setter 를 사용한다.
    println(person.age)
}

class Person3 (
    val name: String,
    var age: Int
) {
    init {  // init (초기화) 블록이 존재하고, 이 블록은 생성자가 호출되는 시점에 호출된다. validation 체크 할 때 유용
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블록")
    }

    constructor(name: String): this(name, 1) {
        println("부생성자 1")
    }
    // constructor(파라미터)로 생성자를 추가
    // this(name, 1) 로 위에 있는 생성자를 호출
    // 주생성자(primary constructor)가 반드시 존재해야 한다. 단, 주생성자에 파라미터가 하나도 없으면 생략 가능.
    // 부생성자(secondary constructor) 최종적으로 주생성자를 this 로 호출해야 한다. 그리고 body 를 가질 수 있다.

    constructor(): this("아무개") {
        println("부생성자 2")
    }

    // kotlin 에서는 부생성자 보다는 default parameter 를 권장하고 있음.
    // Converting 과 같은 경우 부생성자를 사용할 수 있지만, 그보다는 정적 팩토리 메소드를 추천
}

class Person4 (val name: String = "아무개", var age: Int = 10,) {  // 그냥 이렇게 정적 팩토리 메소드로 사용하는게 베스트란 말.
    init {
        if (age <= 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }
}

class Person5 (
    name: String = "아무개",   // getter 생성하지 말라고 val 뺐음
    var age: Int = 10
) {
    var name = name
        get() = field.uppercase()   // 주생성자에서 받은 name 을 불변 프로퍼티 name 에 바로 대입
    // name 에 대한 Custom getter 를 만들 때 field 를 사용
    // field 를 사용하는 이유로 그냥 name.uppercase 를 사용한다면 name 은 name 에 대한 getter 를 호출하니깐 다시 get 을 부름
    // 그럼 무한루프가 발생하기 때문에 그걸 막기 위한 예약어, field 자기 자신을 가리킴, 그래서 이걸 backing field 라고 부른다.
    // 그치만 또 다른 방법도 있기 때문에 backing field 를 사용하는 경우는 잘 없다고 함.

        set(value) {
            field = value.uppercase()   // Setter 자체를 지양하기 때문에 custom setter 도 잘 안씀, 보통 update 관련 함수를 만들어서 사용.
        }

}


class Person6 (
    val name: String = "아무개",
    var age: Int = 10
) {

    // Custom getter 만드는 2가지 (함수를 사용하여 만드냐, getter 를 사용하여 만드냐)
    // 동작으로는 둘 다 똑같음
//    fun isAdult(): Boolean {
//        return this.age >= 20
//    }
//
//    val isAdult: Boolean
//        get() = this.age >= 20



    fun uppercaseName(): String {
        return this.name.uppercase()
    }

    val uppercaseName: String
        get() = this.name.uppercase()


}


/*
kotlin 에서는 필드를 만들면 getter 와 (필요에 따라) setter 가 자동으로 생성된다.
때문에 이를 property 라고 부른다.
kotlin 에서는 주생성자가 필수이다.
kotlin 에서는 constructor 키워드를 사용해 부생성자를 추가로 만들 수 있다.
단, default parameter 나 정적 팩토리 메소드를 추천함.
실제 메모리에 존재하는 것과 무관하게 custom getter 와 custom setter 를 만들 수 있다.
custom getter, custom setter 에서 무한루프를 막기 위해 field 라는 키워드를 사용한다.
이를 backing field 라고 부른다.
 */