package com.example.temptest;

import com.example.temptest.dto.GreenUpdateDto;
import com.example.temptest.entity.GreenEntity;
import com.example.temptest.support.ObjectSupport;
import com.example.temptest.support.UpdateSupport;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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


        final var dto1 = new GreenUpdateDto(11L, null, "변경된테스트");
        final var dto2 = new GreenUpdateDto(12L, null, "변경1테스트");
        final var dto3 = new GreenUpdateDto(13L, 999L, "변경2테스트");
        final var dto4 = new GreenUpdateDto(14L, 999L, "변경3테스트");
        List<GreenUpdateDto> dto11 = List.of(dto1, dto2, dto3, dto4);
        final var collect = dto11.stream()
            .map(greenUpdateDto -> {
                try {
                    return (GreenEntity) ObjectSupport.of(greenUpdateDto, GreenEntity.class, null);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            })
            .collect(Collectors.toList());
        List<GreenEntity> saveList = new ArrayList<>();
        System.out.println("collect = " + collect);
        System.out.println("collect.get(0).getClass() = " + collect.get(0).getClass());
        saveList = collect;
        System.out.println("saveList = " + saveList);
        greenRepository.saveAll(saveList);
    }
}
