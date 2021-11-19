package com.for_antiquarian.antiquarian.mapper;

import com.for_antiquarian.antiquarian.domain.Borrowing;
import com.for_antiquarian.antiquarian.domain.BorrowingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingMapper {

    public Borrowing mapToBorrowing(final BorrowingDto borrowingDto) {
        return new Borrowing(
                borrowingDto.getId(),
                borrowingDto.getBorrowDate(),
                borrowingDto.getReturnDate(),
                borrowingDto.getBook(),
                borrowingDto.getReader()
        );
    }

    public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(
                borrowing.getId(),
                borrowing.getBorrowDate(),
                borrowing.getReturnDate(),
                borrowing.getBook(),
                borrowing.getReader()
        );
    }

    public List<BorrowingDto> mapToBorrowingDtoList(final List<Borrowing> borrowingList) {
        return borrowingList.stream()
                .map(this::mapToBorrowingDto)
                .collect(Collectors.toList());
    }
}

