DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS
(
    ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES
(
    ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    GENRE VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS
(
    ID        BIGINT PRIMARY KEY AUTO_INCREMENT,
    TITLE     VARCHAR(255) NOT NULL,
    DESCRIPTION     TEXT NOT NULL,
    AUTHOR_ID BIGINT REFERENCES AUTHORS(ID),
    GENRE_ID  BIGINT REFERENCES GENRES(ID)
);

DROP TABLE IF EXISTS COMMENTS;
CREATE TABLE COMMENTS
(
    ID BIGINT IDENTITY PRIMARY KEY,
    BOOK_ID BIGINT REFERENCES BOOKS(ID) ON DELETE CASCADE,
    COMMENT CLOB NOT NULL
);