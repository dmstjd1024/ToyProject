package com.dmstjd1024.toyproject.module.zone;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ZoneService {

    private final ZoneRepository zoneRepository;

    @PostConstruct
    public void initZone() throws IOException {
        if(zoneRepository.count() == 0){
            Resource resource = new ClassPathResource("zones.csv");
            List<Zone> zoneList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8).stream()
                    .map(line ->{
                        return Zone.builder().province(line).build();
                    }).collect(Collectors.toList());
            zoneRepository.saveAll(zoneList);
        }
    }
}
