package com.for_antiquarian.antiquarian.facade;

import com.for_antiquarian.antiquarian.domain.Reader;
import com.for_antiquarian.antiquarian.domain.ReaderDto;
import com.for_antiquarian.antiquarian.mapper.ReaderMapper;
import com.for_antiquarian.antiquarian.service.ReaderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public List<ReaderDto> showReaderBySurname(String readerSurname) {
        return readerService.getReaderBySurname(readerSurname);
    }

    public Optional<Reader> showReaderById(Long id) {
        return readerService.getReaderById(id);
    }

}

