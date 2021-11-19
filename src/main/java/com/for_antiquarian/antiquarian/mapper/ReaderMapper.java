package com.for_antiquarian.antiquarian.mapper;

import com.for_antiquarian.antiquarian.domain.Reader;
import com.for_antiquarian.antiquarian.domain.ReaderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getReaderName(),
                readerDto.getReaderSurname(),
                readerDto.getAccountFrom(),
                readerDto.getAccountTo(),
                readerDto.getReaderEmail(),
                readerDto.getReaderAddress(),
                readerDto.getReaderPhoneNumber(),
                readerDto.getReaderStatus()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getReaderName(),
                reader.getReaderSurname(),
                reader.getAccountFrom(),
                reader.getAccountTo(),
                reader.getReaderEmail(),
                reader.getReaderAddress(),
                reader.getReaderPhoneNumber(),
                reader.getReaderStatus()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}

