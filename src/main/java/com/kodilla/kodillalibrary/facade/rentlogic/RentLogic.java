package com.kodilla.kodillalibrary.facade.rentlogic;

import com.kodilla.kodillalibrary.service.LibraryStorageEntryService;
import com.kodilla.kodillalibrary.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentLogic {
    private final LibraryStorageEntryService storageService;
    private final ReaderService readerService;

    public void updateStatus(Long[] indexes, Long status) {
        if (status == 2L) {
            readerService.changeBlacklistStatus(indexes[0], true);
        }
        storageService.changeStatus(indexes[1], status);
    }

    public void payForBook(Long readerId) {
        readerService.changeBlacklistStatus(readerId, false);
    }
}
