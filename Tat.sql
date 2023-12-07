CREATE DATABASE IF NOT EXISTS TATUU;
USE TATUU;

CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Style (
    ID_Style INT AUTO_INCREMENT PRIMARY KEY,
    Name_Style VARCHAR(50) NOT NULL
);

INSERT INTO Style (Name_Style) VALUES ('грандж');

CREATE TABLE IF NOT EXISTS Price_tatu (
    ID_Price_tatu INT AUTO_INCREMENT PRIMARY KEY,
    Price DECIMAL(38,2) NOT NULL

);

-- Вставляем данные
INSERT INTO Price_tatu (Price) VALUES (400);

-- Создаем таблицу цветов татуировок
CREATE TABLE IF NOT EXISTS Color_tatu (
    ID_Color_tatu INT AUTO_INCREMENT PRIMARY KEY,
    Color VARCHAR(50) NOT NULL
);

INSERT INTO Color_tatu (Color) VALUES ('черный');

CREATE TABLE IF NOT EXISTS Tatu (
    ID_Tatu INT AUTO_INCREMENT PRIMARY KEY,
    Sketch VARCHAR(50) NOT NULL,
    Size INT NOT NULL,
    Style_ID INT NOT NULL,
    Color_tatu_ID INT NOT NULL,
    Price_tatu_ID INT NOT NULL,
    FOREIGN KEY (Style_ID) REFERENCES Style (ID_Style),
    FOREIGN KEY (Color_tatu_ID) REFERENCES Color_tatu (ID_Color_tatu),
    FOREIGN KEY (Price_tatu_ID) REFERENCES Price_tatu (ID_Price_tatu)
);

INSERT INTO Tatu (Sketch, Size, Style_ID, Color_tatu_ID, Price_tatu_ID)
VALUES
('../images/tatu1.jpg', 10, 1, 1, 1),
('../images/tatu2.jpg', 10, 1, 1, 1),
('../images/tatu3.jpg', 10, 1, 1, 1),
('../images/tatu4.jpg', 10, 1, 1, 1),
('../images/tatu6.jpg', 10, 1, 1, 1),
('../images/tatu7.jpg', 10, 1, 1, 1),
('../images/tatu8.jpg', 10, 1, 1, 1);

CREATE TABLE IF NOT EXISTS Tattoo_Type (
    ID_Tattoo_Type INT AUTO_INCREMENT PRIMARY KEY,
    Type_Name VARCHAR(50) NOT NULL
);

INSERT INTO Tattoo_Type (Type_Name) VALUES ('Рукав'),
                                           ('Спина'),
                                           ('Нога');

CREATE TABLE IF NOT EXISTS Client (
    ID_Client INT AUTO_INCREMENT PRIMARY KEY,
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Phone_Number VARCHAR(20) NOT NULL,
    Email VARCHAR(100),
    UNIQUE INDEX UQ_Phone_Number (Phone_Number)
);

INSERT INTO Client (First_Name, Last_Name, Phone_Number, Email) VALUES ('Иван', 'Иванов', '123456789', 'ivan@example.com'),
                                                                      ('Мария', 'Петрова', '987654321', 'maria@example.com');

CREATE TABLE IF NOT EXISTS Tattoo_History (
    ID_Tattoo_History INT AUTO_INCREMENT PRIMARY KEY,
    Tatu_ID INT NOT NULL,
    Client_ID INT NOT NULL,
    Tattoo_Type_ID INT NOT NULL,
    Date_Tattoo DATE NOT NULL,
    FOREIGN KEY (Tatu_ID) REFERENCES Tatu (ID_Tatu),
    FOREIGN KEY (Client_ID) REFERENCES Client (ID_Client),
    FOREIGN KEY (Tattoo_Type_ID) REFERENCES Tattoo_Type (ID_Tattoo_Type)
);

INSERT INTO Tattoo_History (Tatu_ID, Client_ID, Tattoo_Type_ID, Date_Tattoo)
VALUES (1, 1, 1, '2022-12-01'),
       (2, 2, 2, '2022-11-15'),
       (3, 1, 3, '2022-10-20');

CREATE TABLE IF NOT EXISTS Tattoo_Studio (
    ID_Tattoo_Studio INT AUTO_INCREMENT PRIMARY KEY,
    Studio_Name VARCHAR(100) NOT NULL,
    Location VARCHAR(255) NOT NULL
);

INSERT INTO Tattoo_Studio (Studio_Name, Location) VALUES ('InkMaster Studio', 'Город, улица, дом'),
                                                     ('Artistic Ink', 'Город, другая улица, дом');
                                                     
 CREATE TABLE IF NOT EXISTS Piercing_Type (
    ID_Piercing_Type INT AUTO_INCREMENT PRIMARY KEY,
    Type_Name VARCHAR(50) NOT NULL
);

-- Вставляем данные
INSERT INTO Piercing_Type (Type_Name) VALUES ('Нос'),
                                           ('Ухо'),
                                           ('Язык');                                                    