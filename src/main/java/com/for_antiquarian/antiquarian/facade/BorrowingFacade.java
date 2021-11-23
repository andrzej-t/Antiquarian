package com.for_antiquarian.antiquarian.facade;

import com.for_antiquarian.antiquarian.domain.BorrowingDto;
import com.for_antiquarian.antiquarian.mapper.BorrowingMapper;
import com.for_antiquarian.antiquarian.service.BorrowingService;
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
public class BorrowingFacade {

    @Autowired
    BorrowingService borrowingService;

    @Autowired
    BorrowingMapper borrowingMapper;

    public List<BorrowingDto> showAllBorrowings() { return borrowingService.findAllBorrowings(); }

    public void addNewBorrowing(BorrowingDto borrowingDto) {
        borrowingService.insertNewBorrowing(borrowingDto);
    }

    public List<BorrowingDto> showBorrowingsByReaderId(Long id) { return borrowingService.getBorrowingsByReaderId(id); }

}

