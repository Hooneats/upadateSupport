package com.example.temptest;

import com.example.temptest.dto.GreenUpdateDto;
import com.example.temptest.entity.GreenEntity;
import com.example.temptest.support.UpdateSupport;
import java.util.Optional;
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
        final var entity = new GreenEntity(1L, "테스트삽입", 4L);
        greenRepository.save(entity);
    }


    @Transactional
    public void update() {
        final var entity = greenRepository.findById(1L).get();
        System.out.println("entity = " + entity);
        final var dto = new GreenUpdateDto(1L, 999L, "변경된테스트");
        final var entity1 = updateObject(
             Optional.of(dto), Optional.of(entity)
        ).get();
        System.out.println("entity1 = " + entity1);
        System.out.println("getClass = " + entity1.getClass());
    }
}
