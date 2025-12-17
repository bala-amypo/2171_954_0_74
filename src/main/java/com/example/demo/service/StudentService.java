package com.example.demo.service;

import java.util.*;

import org.springframework.stereotype.Service;
import com.example.demo.entity.student;

@Service
public class StudserviceImpl implements Studentservice {

    private final Map<Long, Student> store = new HashMap<>();

    @Override
    public Student insertStudent(Student st) {
        store.put(st.getId(), st);
        return st;
    }

    @Override
    public List<Student> getAllStudent() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Student> getOneStudent(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteStudent(Long id) {
        store.remove(id);
    }
}