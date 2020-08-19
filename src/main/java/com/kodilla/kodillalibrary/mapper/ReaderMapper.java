package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.reader.Reader;
import com.kodilla.kodillalibrary.domain.reader.ReaderDto;
import com.kodilla.kodillalibrary.domain.reader.ReaderRentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RentMapper.class})
public interface ReaderMapper {

    @Mapping(target = "rentList", expression = "java(rentMapper.mapFetchedRentDtoListToRentList(readerDto.getRentList()))")
    Reader mapToReader(ReaderDto readerDto);

    @Mapping(target = "rentList", ignore = true)
    Reader mapToReader(ReaderRentDto readerRentDto);

    ReaderDto mapToReaderDto(Reader reader);

    @Mapping(target = "rentList", ignore = true)
    ReaderDto mapToReaderDto(ReaderRentDto reader);

    ReaderRentDto mapToReaderRentDto(Reader reader);


    List<ReaderDto> mapToReaderDtoList(List<Reader> readerList);

}
