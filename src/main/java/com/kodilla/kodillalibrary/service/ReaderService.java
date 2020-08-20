package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.reader.Reader;
import com.kodilla.kodillalibrary.domain.reader.ReaderDto;
import com.kodilla.kodillalibrary.exception.ReaderException;
import com.kodilla.kodillalibrary.mapper.ReaderMapper;
import com.kodilla.kodillalibrary.service.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository repository;
    private final ReaderMapper mapper;

    public List<ReaderDto> getAllReaders() {
        return mapper.mapToReaderDtoList(repository.findAll());
    }

    public ReaderDto getReaderById(Long readerId) {
        Reader fetchedReader = repository.findById(readerId).orElseThrow(() -> new ReaderException(ReaderException.ERR_READER_NOT_FOUND_EXCEPTION));
        return mapper.mapToReaderDto(fetchedReader);
    }

    public ReaderDto updateReader(ReaderDto readerDto) {
        if (readerDto.getId() != null) {
            isReaderExisting(readerDto.getId());
        } else {
            throw new ReaderException(ReaderException.ERR_READER_ID_MUST_BE_NOT_NULL_EXCEPTION);
        }
        Reader updatedReader = repository.save(mapper.mapToReader(readerDto));
        return mapper.mapToReaderDto(updatedReader);
    }

    public ReaderDto createReader(ReaderDto readerDto) {
        if (readerDto.getId() == null || readerDto.getId() == 0L) {
            readerDto.setBlacklisted(false);
            Reader updatedReader = repository.save(mapper.mapToReader(readerDto));
            return mapper.mapToReaderDto(updatedReader);
        } else {
            throw new ReaderException(ReaderException.ERR_READER_ID_MUST_BE_NULL_OR_0_EXCEPTION);
        }
    }

    public void changeBlacklistStatus(Long readerId, boolean status) {
        if (readerId != null) {
            isReaderExisting(readerId);
        } else {
            throw new ReaderException(ReaderException.ERR_READER_ID_MUST_BE_NOT_NULL_EXCEPTION);
        }
        Reader fetchedReader = repository.findById(readerId).orElseThrow(() -> new ReaderException(ReaderException.ERR_READER_NOT_FOUND_EXCEPTION));
        fetchedReader.setBlacklisted(status);
        repository.save(fetchedReader);
    }

    public void deleteReader(Long readerId) {
        repository.deleteById(readerId);
    }

    private void isReaderExisting(Long readerId) {
        if (!repository.existsById(readerId)) {
            throw new ReaderException(ReaderException.ERR_READER_NOT_EXIST_EXCEPTION);
        }
    }
}
