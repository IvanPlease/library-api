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

    CreatedBookDto mapToCreatedBookDto(Book book);

    StorageBookDto mapToStorageBookDto(Book book);

    List<BookDto> mapToBookDtoList(List<Book> bookDto);
}
