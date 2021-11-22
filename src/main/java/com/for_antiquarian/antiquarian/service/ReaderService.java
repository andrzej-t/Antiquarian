package com.for_antiquarian.antiquarian.service;

import com.for_antiquarian.antiquarian.domain.ReaderDto;
import com.for_antiquarian.antiquarian.mapper.ReaderMapper;
import com.for_antiquarian.antiquarian.repository.ReaderRepository;
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
public class ReaderService {

    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    ReaderMapper readerMapper;

    public List<ReaderDto> findAllReaders() { return readerMapper.mapToReaderDtoList(readerRepository.findAll()); }

    public List<ReaderDto> getReaderBySurname(String readerSurname) { return readerMapper.mapToReaderDtoList(readerRepository.findAllByReaderSurname(readerSurname)); }
}

