package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class BookMapper {

    public Book mapToBook(BookDto bookDto){
        return Book.builder()
                .bookId(bookDto.getBookId())
                .bookAuthor(bookDto.getBookAuthor())
                .copyList(mapToLibraryStorageEntryList(bookDto.getCopyList()))
                .bookTitle(bookDto.getBookTitle())
                .build();
    }

    public BookDto mapToBookDto(Book book){
        return BookDto.builder()
                .bookId(book.getBookId())
                .bookTitle(book.getBookTitle())
                .bookAuthor(book.getBookAuthor())
                .copyList(mapToLibraryStorageEntryDtoList(book.getCopyList()))
                .pubYear(book.getPubYear())
                .build();
    }

    public List<Rent> mapToRentList(List<RentDto> rentDtoList){
        return rentDtoList.stream()
                .map(this::mapToRent)
                .collect(toList());
    }

    public List<RentDto> mapToRentDtoList(List<Rent> rentList){
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(toList());
    }

    public Rent mapToRent(RentDto rentDto){
        return Rent.builder()
                .reader(mapToReader(rentDto.getReader()))
                .rentId(rentDto.getRentId())
                .rentDate(rentDto.getRentDate())
                .returnDate((rentDto.getReturnDate()==null) ? null:rentDto.getReturnDate())
                .build();
    }

    public RentDto mapToRentDto(Rent rent){
        return RentDto.builder()
                .reader(mapToReaderDto(rent.getReader()))
                .rentId(rent.getRentId())
                .rentDate(rent.getRentDate())
                .returnDate((rent.getReturnDate()==null) ? null:rent.getReturnDate())
                .build();
    }

    public Reader mapToReader(ReaderDto readerDto){
        return Reader.builder()
                .readerId(readerDto.getReaderId())
                .creationDate(readerDto.getCreationDate())
                .firstname(readerDto.getFirstname())
                .lastname(readerDto.getLastname())
                .rentList(mapToRentList(readerDto.getRentList()))
                .build();
    }

    public ReaderDto mapToReaderDto(Reader reader){
        return ReaderDto.builder()
                .readerId(reader.getReaderId())
                .creationDate(reader.getCreationDate())
                .firstname(reader.getFirstname())
                .lastname(reader.getLastname())
                .rentList(mapToRentDtoList(reader.getRentList()))
                .build();
    }

    public List<LibraryStorageEntry> mapToLibraryStorageEntryList(List<LibraryStorageEntryDto> libraryStorageEntryDtoList){
        return libraryStorageEntryDtoList.stream()
                .map(this::mapToLibraryStorageEntry)
                .collect(toList());
    }

    public List<LibraryStorageEntryDto> mapToLibraryStorageEntryDtoList(List<LibraryStorageEntry> libraryStorageEntryList){
        return libraryStorageEntryList.stream()
                .map(this::mapToLibraryStorageEntryDto)
                .collect(toList());
    }

    public LibraryStorageEntry mapToLibraryStorageEntry(LibraryStorageEntryDto libraryStorageEntryDto) {
        return LibraryStorageEntry.builder()
                .book(mapToBook(libraryStorageEntryDto.getBook()))
                .copyId(libraryStorageEntryDto.getCopyId())
                .entryId(libraryStorageEntryDto.getEntryId())
                .rentList(mapToRentList(libraryStorageEntryDto.getRentList()))
                .status(libraryStorageEntryDto.isStatus())
                .build();
    }

    public LibraryStorageEntryDto mapToLibraryStorageEntryDto(LibraryStorageEntry libraryStorageEntry) {
        return LibraryStorageEntryDto.builder()
                .book(mapToBookDto(libraryStorageEntry.getBook()))
                .copyId(libraryStorageEntry.getCopyId())
                .entryId(libraryStorageEntry.getEntryId())
                .rentList(mapToRentDtoList(libraryStorageEntry.getRentList()))
                .status(libraryStorageEntry.isStatus())
                .build();
    }
}
