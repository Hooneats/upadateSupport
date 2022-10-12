package com.example.temptest;

import com.example.temptest.dto.GreenUpdateDto;
import com.example.temptest.entity.GreenEntity;
import com.example.temptest.support.UpdateSupport;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TestService implements UpdateSupport {

    private final GreenRepository greenRepository;

    @Transactional
    @PostConstruct
    public void insert() {
        final var entity1 = new GreenEntity(1L, "테스트삽입1", 4L);
        final var entity2 = new GreenEntity(2L, "테스트삽입2", 5L);
        final var entity3 = new GreenEntity(3L, "테스트삽입3", 6L);
        greenRepository.save(entity1);
        greenRepository.save(entity2);
        greenRepository.save(entity3);
    }


    @Transactional
    public void update() {
        final var entity1 = greenRepository.findById(1L);
        final var entity2 = greenRepository.findById(2L);
        System.out.println("entity1 = " + entity1);
        final var dto1 = new GreenUpdateDto(1L, 999L, "변경된테스트");
        final var dto2 = new GreenUpdateDto(2L, 999L, "변경된테스트");

        updateObject(
            dto1, entity1
        );
        updateObject(
            dto2, entity2
        );
        System.out.println("entity1 = " + entity1);
        System.out.println("getClass = " + entity1.getClass());
    }
}
