package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.book.Book;
import com.kodilla.kodillalibrary.domain.book.BookDto;
import com.kodilla.kodillalibrary.domain.book.CreatedBookDto;
import com.kodilla.kodillalibrary.domain.book.StorageBookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StorageEntryMapper.class})
public interface BookMapper {
    @Mapping(target = "copyList", expression = "java(storageEntryMapper.mapEntryDtoToLibraryStorageEntryList(bookDto.getCopyList()))")
    Book mapToBook(BookDto bookDto);

    @Mapping(target = "copyList", expression = "java(new ArrayList<>())")
    Book mapToBook(CreatedBookDto bookDto);

    @Mapping(target = "copyList", ignore = true)
    Book mapToBook(StorageBookDto bookDto);

    BookDto mapToBookDto(Book book);

    BookDto mapToBookDto(CreatedBookDto book);

    @Mapping(target = "copyList", ignore = true)
    BookDto mapToBookDto(StorageBookDto bookDto);

    CreatedBookDto mapToCreatedBookDto(Book book);

    CreatedBookDto mapToCreatedBookDto(BookDto book);

    @Mapping(target = "copyList", ignore = true)
    CreatedBookDto mapToCreatedBookDto(StorageBookDto book);

    StorageBookDto mapToStorageBookDto(Book book);

    StorageBookDto mapToStorageBookDto(BookDto book);

    List<BookDto> mapToBookDtoList(List<Book> bookDto);
}
