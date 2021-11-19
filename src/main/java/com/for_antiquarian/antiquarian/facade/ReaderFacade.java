package com.for_antiquarian.antiquarian.facade;

import com.for_antiquarian.antiquarian.domain.ReaderDto;
import com.for_antiquarian.antiquarian.mapper.ReaderMapper;
import com.for_antiquarian.antiquarian.service.ReaderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class ReaderFacade {

    @Autowired
    ReaderService readerService;

    @Autowired
    ReaderMapper readerMapper;

    public List<ReaderDto> showAllReaders() {
        return readerService.findAllReaders();
    }
}

