package com.for_antiquarian.antiquarian.service;

import com.for_antiquarian.antiquarian.domain.BorrowingDto;
import com.for_antiquarian.antiquarian.mapper.BorrowingMapper;
import com.for_antiquarian.antiquarian.repository.BorrowingRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class BorrowingService {

    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BorrowingMapper borrowingMapper;

    public List<BorrowingDto> findAllBorrowings() {
        return borrowingMapper.mapToBorrowingDtoList(borrowingRepository.findAll());
    }

    @Transactional
    public void insertNewBorrowing(BorrowingDto borrowingDto) {
        borrowingRepository.save(borrowingMapper.mapToBorrowing(borrowingDto));
    }

    @Transactional
    public List<BorrowingDto> getBorrowingsByReaderId(Long id) {

        return borrowingMapper.mapToBorrowingDtoList(borrowingRepository.findByReaderId(id));
    }

}

