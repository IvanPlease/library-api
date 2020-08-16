package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class BookMapper {

    public Book mapToBook(BookDto bookDto) {
        List<LibraryStorageEntry> storageEntries;
        if (bookDto.getCopyList() != null) {
            storageEntries = mapToLibraryStorageEntryList(bookDto.getCopyList());
        } else {
            storageEntries = new ArrayList<>();
        }
        return Book.builder()
                .bookId(bookDto.getBookId())
                .bookAuthor(bookDto.getBookAuthor())
                .copyList(storageEntries)
                .bookTitle(bookDto.getBookTitle())
                .pubYear(bookDto.getPubYear())
                .build();
    }

    public BookDto mapToBookDto(Book book) {
        List<LibraryStorageEntryDto> storageEntries;
        if (book.getCopyList() != null) {
            storageEntries = mapToLibraryStorageEntryDtoList(book.getCopyList());
        } else {
            storageEntries = new ArrayList<>();
        }
        return BookDto.builder()
                .bookId(book.getBookId())
                .bookTitle(book.getBookTitle())
                .bookAuthor(book.getBookAuthor())
                .copyList(storageEntries)
                .pubYear(book.getPubYear())
                .build();
    }

    public List<Rent> mapToRentList(List<RentDto> rentDtoList) {
        return rentDtoList.stream()
                .map(this::mapToRent)
                .collect(toList());
    }

    public List<RentDto> mapToRentDtoList(List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(toList());
    }

    public Rent mapToRent(RentDto rentDto) {
        return Rent.builder()
                .reader(mapToReader(rentDto.getReader()))
                .rentId(rentDto.getRentId())
                .rentDate(rentDto.getRentDate())
                .returnDate((rentDto.getReturnDate() == null) ? null : rentDto.getReturnDate())
                .build();
    }

    public RentDto mapToRentDto(Rent rent) {
        return RentDto.builder()
                .reader(mapToReaderDto(rent.getReader()))
                .rentId(rent.getRentId())
                .rentDate(rent.getRentDate())
                .returnDate((rent.getReturnDate() == null) ? null : rent.getReturnDate())
                .build();
    }

    public Reader mapToReader(ReaderDto readerDto) {
        List<Rent> rentList;
        if (readerDto.getRentList() != null) {
            rentList = mapToRentList(readerDto.getRentList());
        } else {
            rentList = new ArrayList<>();
        }
        return Reader.builder()
                .readerId(readerDto.getReaderId())
                .creationDate(readerDto.getCreationDate())
                .firstname(readerDto.getFirstname())
                .lastname(readerDto.getLastname())
                .rentList(rentList)
                .build();
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        List<RentDto> rentDtoList;
        if (reader.getRentList() != null) {
            rentDtoList = mapToRentDtoList(reader.getRentList());
        } else {
            rentDtoList = new ArrayList<>();
        }
        return ReaderDto.builder()
                .readerId(reader.getReaderId())
                .creationDate(reader.getCreationDate())
                .firstname(reader.getFirstname())
                .lastname(reader.getLastname())
                .rentList(rentDtoList)
                .build();
    }

    public LibraryStorageEntry mapToLibraryStorageEntry(LibraryStorageEntryDto libraryStorageEntryDto) {
        List<Rent> rentList;
        if (libraryStorageEntryDto.getRentList() != null) {
            rentList = mapToRentList(libraryStorageEntryDto.getRentList());
        } else {
            rentList = new ArrayList<>();
        }
        return LibraryStorageEntry.builder()
                .book(mapToBook(libraryStorageEntryDto.getBook()))
                .copyId(libraryStorageEntryDto.getCopyId())
                .entryId(libraryStorageEntryDto.getEntryId())
                .rentList(rentList)
                .status(libraryStorageEntryDto.getStatus())
                .build();
    }

    public LibraryStorageEntryDto mapToLibraryStorageEntryDto(LibraryStorageEntry libraryStorageEntry) {
        List<RentDto> rentDtoList;
        if (libraryStorageEntry.getRentList() != null) {
            rentDtoList = mapToRentDtoList(libraryStorageEntry.getRentList());
        } else {
            rentDtoList = new ArrayList<>();
        }
        return LibraryStorageEntryDto.builder()
                .book(mapToBookDto(libraryStorageEntry.getBook()))
                .copyId(libraryStorageEntry.getCopyId())
                .entryId(libraryStorageEntry.getEntryId())
                .rentList(rentDtoList)
                .status(libraryStorageEntry.getStatus())
                .build();
    }

    public List<LibraryStorageEntry> mapToLibraryStorageEntryList(List<LibraryStorageEntryDto> libraryStorageEntryDtoList) {
        return libraryStorageEntryDtoList.stream()
                .map(this::mapToLibraryStorageEntry)
                .collect(toList());
    }

    public List<LibraryStorageEntryDto> mapToLibraryStorageEntryDtoList(List<LibraryStorageEntry> libraryStorageEntryList) {
        return libraryStorageEntryList.stream()
                .map(this::mapToLibraryStorageEntryDto)
                .collect(toList());
    }

    public List<BookDto> mapToBookDtoList(List<Book> books) {
        return books.stream()
                .map(this::mapToBookDto)
                .collect(toList());
    }

    public List<Book> mapToBookList(List<BookDto> bookDtoList) {
        return bookDtoList.stream()
                .map(this::mapToBook)
                .collect(toList());
    }

    public List<ReaderDto> mapToReaderDtoList(List<Reader> readerList) {
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(toList());
    }
}
