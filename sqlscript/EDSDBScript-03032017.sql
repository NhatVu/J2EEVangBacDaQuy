use EDSDB_MYSQL;

create table UserType (
 Id int NOT NULL AUTO_INCREMENT primary key,
    UserType nvarchar(50)
);

Create table User (
 Id int NOT NULL AUTO_INCREMENT primary key,
 Username nvarchar(100),
    Password varchar(500),
    Email varchar(100),
    Fullname nvarchar(100),
    Phone varchar(20),
    UserTypeId int, 
    constraint FK_User_UserType foreign key (UserTypeId) references UserType(Id)
);

Create table Topic(
	Id int NOT NULL AUTO_INCREMENT primary key,
	topic varchar(100),
	keyword nvarchar(1000)
);


ALTER DATABASE EDSDB_MYSQL CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Topic CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


INSERT INTO `EDSDB_MYSQL`.`UserType` (`Id`, `UserType`) VALUES ('1', 'Admin');
INSERT INTO `EDSDB_MYSQL`.`UserType` (`Id`, `UserType`) VALUES ('2', 'Editor');
INSERT INTO `EDSDB_MYSQL`.`UserType` (`Id`, `UserType`) VALUES ('3', 'User');

INSERT INTO `EDSDB_MYSQL`.`User` (`Username`, `Password`, `Email`, `Fullname`, `Phone`, `UserTypeId`) VALUES ('oneadmin', 'oneadmin', 'tinhuynhngoc@admicro.vn', 'Huỳnh Ngọc Tín', '0989241516', '1');
INSERT INTO `EDSDB_MYSQL`.`User` (`Username`, `Password`, `Email`, `Fullname`, `Phone`, `UserTypeId`) VALUES ('editor', 'editor', 'tinhuynhngoc@admicro.vn', 'Huỳnh Ngọc Tín', '0989241516', '2');

INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('1', 'Accident', 'tai nạn, chết người, thảm khốc, rơi máy bay, tai nạn máy bay, máy bay mất tích, #tainan, #tainạn, #chetnguoi, #chếtngười');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('2', 'Act of Violence or War', 'thả bom, đánh bom, tên lửa, hạt nhân, bom hạt nhân, đầu đạn hạt nhân, vũ khí, vũ khí huỷ diệt, xả súng, khủng bố, #đánhbom, #khủngbố');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('3', 'Bizarre News and World Records', 'kỷ lục thế giới, Guinness, chuyện lạ có thật, chuyện lạ khó tin, chuyện lạ bốn phương, phong tục kỳ lạ');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('4', 'Celebrity and Human Interest News', 'tổng thống, tổng bí thư, thủ tướng, chủ tịch nước, phát ngôn, phát ngôn gây sốc, Barack Obama, Donald Trump, Putin, Shinzo Abe, Tập Cận Bình, Rodrigo Duterte, Nguyễn Phú Trọng, Nguyễn Xuân Phúc, Trần Đại Quang, Nguyễn Thị Kim Ngân, Ca sĩ, Hoa hậu, Người mẫu, Diễn viên');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('5', 'Election', 'đại hội đảng, bầu cử, bầu cử đại biểu quốc hội, bầu cử tổng thống, #baucu, #bầucử');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('6', 'Financial', 'xăng lên giá, xăng giảm giá, chứng khoán, bất động sản, chấn động thị trường, #taichinh, #tàichính');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('7', 'General', 'tin nóng, tin giật gân, #tinnong, #tinnóng, #tingiatgan, #tingiậtgân');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('8', 'Legal and Criminal Case', 'cướp, giết người, khủng khiếp, hãm hiếp, hiếp dâm, lạm dụng tình dục, tham ô, tham nhũng, #gietnguoi, #giếtngười');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('9', 'Natural Disaster', 'động đất, sóng thần, lũ lụt, mưa đá, thiên tai, bão lớn, #thientai, #thiêntai');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('10', 'New Law', 'dự thảo luật, điều luật mới, chính sách mới');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('11', 'Political Meeting', 'tổng thống, tổng bí thư, thủ tướng, chủ tịch nước, hội nghị, cuộc gặp gỡ, gặp mặt, họp mặt');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('12', 'Scandal and Hearing', 'bê bối, quấy rối, quấy rối tình dục, hầu tòa, ra tòa, scandal, #scandal');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('13', 'Science and Discovery', 'phát minh, giải nobel, giải fields, khám phá mới, phát hiện mới');
INSERT INTO `EDSDB_MYSQL`.`Topic` (`Id`, `topic`, `keyword`) VALUES ('14', 'Sport', 'đội tuyển bóng đá quốc gia, đội tuyển U19, U19 Hoàng Anh Gia Lai, SeaGames, AFC Suzuki Cup, #bongda, #bóngđá');