package com.kodilla.kodillalibrary.facade;

import com.kodilla.kodillalibrary.domain.ReaderDto;
import com.kodilla.kodillalibrary.service.ReaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReaderFacade {

    private final ReaderService service;

    public List<ReaderDto> fetchAllReaders() {
        return service.getAllReaders();
    }

    public ReaderDto fetchReaderById(Long readerId) {
        return service.getReaderById(readerId);
    }

    public ReaderDto updateReader(ReaderDto readerDto) {
        return service.updateReader(readerDto);
    }

    public ReaderDto createReader(ReaderDto readerDto) {
        return service.createReader(readerDto);
    }

    public void deleteReader(Long readerId) {
        service.deleteReader(readerId);
    }
}
