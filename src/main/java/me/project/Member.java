package me.project;

/**
 * username: 유일성 보장
 * name: 중복 허용
 * age: 나이
 */
public class Member implements Comparable<Member> {
    private final String username;
    private final String name;
    private final int age;

    public Member(String username, String name, int age) {
        this.username = username;
        this.name = name;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Member o) {
        return Integer.compare(this.age, o.getAge());
    }
}
