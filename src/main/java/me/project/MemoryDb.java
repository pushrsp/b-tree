package me.project;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryDb {
    private final List<Member> arr = new ArrayList<>();
    private final Map<String, Integer> byUsername = new HashMap<>();
    private final Map<String, List<Integer>> byName = new HashMap<>();

    public void add(Member member) {
        if(byUsername.containsKey(member.getUsername())) {
            return;
        }

        byUsername.put(member.getUsername(), arr.size());

        if(byName.containsKey(member.getName())) {
            byName.get(member.getName()).add(arr.size());
        } else {
            List<Integer> l = new ArrayList<>();
            l.add(arr.size());
            byName.put(member.getName(), l);
        }

        arr.add(member);
    }

    public Optional<Member> getByUsername(String username) {
        if(!byUsername.containsKey(username)) {
            return Optional.empty();
        }

        return Optional.of(arr.get(byUsername.get(username)));
    }

    public List<Member> getByName(String name) {
        if(!byName.containsKey(name)) {
            return List.of();
        }

        return byName.get(name).stream()
                .map(arr::get)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return arr.size();
    }
}
