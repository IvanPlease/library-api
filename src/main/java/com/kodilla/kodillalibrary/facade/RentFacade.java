package com.kodilla.kodillalibrary.facade;

import com.kodilla.kodillalibrary.domain.RentDto;
import com.kodilla.kodillalibrary.exception.ReaderException;
import com.kodilla.kodillalibrary.exception.RentException;
import com.kodilla.kodillalibrary.facade.rentlogic.RentLogic;
import com.kodilla.kodillalibrary.service.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class RentFacade {

    private final RentService service;
    private final RentLogic logic;

    public List<RentDto> fetchAllRents() {
        return service.getAllRents();
    }

    public RentDto fetchRentById(Long readerId) {
        return service.getRentById(readerId);
    }

    public RentDto updateRent(RentDto rentDto, boolean status) {
        Long[] indexes = {
                rentDto.getStorageEntry().getEntryId(),
                rentDto.getReader().getReaderId()
        };
        logic.updateStatus(indexes, (status) ? 0L : 2L);
        if (status) {
            return service.updateRent(rentDto);
        } else {
            throw new RentException(RentException.ERR_RENT_LOST_AWAITING_PAYMENT_EXCEPTION);
        }
    }

    public RentDto createRent(RentDto rentDto) {
        if (!rentDto.getReader().isBlackListed()) {
            Long[] indexes = {
                    rentDto.getStorageEntry().getEntryId(),
                    rentDto.getReader().getReaderId()
            };
            logic.updateStatus(indexes, 1L);
            return service.createRent(rentDto);
        } else {
            throw new ReaderException(ReaderException.ERR_READER_BLACKLIST_EXCEPTION);
        }
    }

    public RentDto payForLostBook(Long rentId) {
        RentDto fetchedRentDto = service.getRentById(rentId);
        logic.payForBook(fetchedRentDto.getReader().getReaderId());
        return service.getRentById(rentId);
    }

    public void deleteRent(Long readerId) {
        service.deleteRent(readerId);
    }
}
