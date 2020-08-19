package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.rent.FetchedRentDto;
import com.kodilla.kodillalibrary.domain.rent.Rent;
import com.kodilla.kodillalibrary.domain.rent.RentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StorageEntryMapper.class, ReaderMapper.class})
public interface RentMapper {
    Rent mapToRent(RentDto rentDto);

    @Mappings({
            @Mapping(target = "storageEntry", ignore = true),
            @Mapping(target = "reader", ignore = true)
    })
    Rent mapToRent(FetchedRentDto fetchedRentDto);

    @Mappings({
            @Mapping(target = "reader", expression = "java(readerMapper.mapToReaderRentDto(rent.getReader()))"),
            @Mapping(target = "storageEntry", expression = "java(storageEntryMapper.mapToLibraryStorageEntryDto(rent.getStorageEntry()))")
    })
    RentDto mapToRentDto(Rent rent);

    @Mappings({
            @Mapping(target = "entryId", source = "storageEntry.id"),
            @Mapping(target = "readerId", source = "reader.id")
    })
    FetchedRentDto mapToFetchedRentDto(Rent rent);

    List<Rent> mapFetchedRentDtoListToRentList(List<FetchedRentDto> rentDtoList);

    List<RentDto> mapToRentDtoList(List<Rent> rentDtoList);

    List<FetchedRentDto> mapToFetchedDtoList(List<Rent> rentDtoList);
}
