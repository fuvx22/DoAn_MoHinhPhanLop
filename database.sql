-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 05, 2023 lúc 06:33 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `back_book`
--

CREATE TABLE `back_book` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `reader_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `back_date` date NOT NULL,
  `lib_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `back_book`
--

INSERT INTO `back_book` (`id`, `book_id`, `reader_id`, `quantity`, `back_date`, `lib_id`) VALUES
(16, 2, 2, 2, '2023-05-05', 1),
(17, 1, 3, 2, '2023-05-05', 1),
(18, 5, 2, 2, '2023-05-05', 1),
(19, 1, 2, 3, '2023-05-05', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `books`
--

CREATE TABLE `books` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `author` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `borrow_quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `author`, `release_date`, `quantity`, `borrow_quantity`) VALUES
(1, 'Java', 'Phu Le', '2020-09-22', 15, 1),
(2, 'C#', 'James', '2018-04-11', 20, 0),
(3, 'How to become rich 2', 'Michel Nguyen1', '1989-05-31', 30, 1),
(4, 'Python', 'Kenrick Jr', '1974-01-30', 15, 0),
(5, 'Thao túng tâm lý', 'Shannon Thomas', '2017-04-25', 20, 0),
(6, 'C++', 'John St', '1972-11-20', 20, 0),
(7, 'Golang', 'Austin Reave', '1990-01-26', 30, 2),
(8, 'Sunday the king play', 'Messi the GOAT', '2022-09-18', 20, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `librarian`
--

CREATE TABLE `librarian` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `log_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `log_pw` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `librarian`
--

INSERT INTO `librarian` (`id`, `name`, `address`, `log_name`, `log_pw`) VALUES
(1, 'Phú Võ', '19 Số 10, P. Bình Hưng Hòa', 'phu2901', '776b17c9537e76399ae011646671afe2f04c88731f497c0ac89a91eb3908e07f'),
(4, 'Hoàng Phúc', '123 Nguyễn Trãi', 'phuc1234', '0a69bcc905640b9998812b9033cf8ec88769591cd935c9158ae9d372ec8bebed');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loan_book`
--

CREATE TABLE `loan_book` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `reader_id` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `loan_date` date NOT NULL,
  `exp_date` date NOT NULL,
  `lib_id` int(11) DEFAULT NULL,
  `state` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loan_book`
--

INSERT INTO `loan_book` (`id`, `book_id`, `reader_id`, `quantity`, `loan_date`, `exp_date`, `lib_id`, `state`) VALUES
(14, 1, 3, 2, '2023-05-05', '2023-05-06', 1, 'returned'),
(15, 2, 2, 2, '2023-05-05', '2023-05-07', 1, 'returned'),
(16, 5, 2, 2, '2023-05-05', '2023-05-06', 1, 'returned'),
(17, 1, 2, 3, '2023-05-05', '2023-05-07', 1, 'returned'),
(18, 3, 4, 1, '2023-05-05', '2023-05-08', 1, 'active'),
(19, 1, 1, 1, '2023-05-05', '2023-05-07', 1, 'active'),
(20, 7, 3, 2, '2023-05-05', '2023-05-09', 4, 'active');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `readers`
--

CREATE TABLE `readers` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone_number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `readers`
--

INSERT INTO `readers` (`id`, `name`, `phone_number`, `address`) VALUES
(1, 'Phu Vo', '0984833529', '19 number 10 st'),
(2, 'James', '0986575447', '255 Nguyen Trai'),
(3, 'Peter', '0905478564', '20 Le Thuc Hoach'),
(4, 'Hoang Phuc', '07445711645', 'somewhere quan 8');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `back_book`
--
ALTER TABLE `back_book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_back_book_books` (`book_id`),
  ADD KEY `FK_back_book_librarian` (`lib_id`),
  ADD KEY `FK_back_book_readers` (`reader_id`);

--
-- Chỉ mục cho bảng `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- Chỉ mục cho bảng `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loan_book`
--
ALTER TABLE `loan_book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_loan_book_books` (`book_id`),
  ADD KEY `FK_loan_book_readers` (`reader_id`),
  ADD KEY `FK_loan_book_librarian` (`lib_id`);

--
-- Chỉ mục cho bảng `readers`
--
ALTER TABLE `readers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `back_book`
--
ALTER TABLE `back_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `librarian`
--
ALTER TABLE `librarian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `loan_book`
--
ALTER TABLE `loan_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `readers`
--
ALTER TABLE `readers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `back_book`
--
ALTER TABLE `back_book`
  ADD CONSTRAINT `FK_back_book_books` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_back_book_librarian` FOREIGN KEY (`lib_id`) REFERENCES `librarian` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_back_book_readers` FOREIGN KEY (`reader_id`) REFERENCES `readers` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `loan_book`
--
ALTER TABLE `loan_book`
  ADD CONSTRAINT `FK_loan_book_books` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_loan_book_librarian` FOREIGN KEY (`lib_id`) REFERENCES `librarian` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_loan_book_readers` FOREIGN KEY (`reader_id`) REFERENCES `readers` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
