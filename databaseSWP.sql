USE [master]
nguyen tuan dung
GO
/****** Object:  Database [SE1827_SWP391_OnlineLearning]    Script Date: 5/16/2024 4:58:50 PM ******/
CREATE DATABASE [SE1827_SWP391_OnlineLearning]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SE1827_SWP391_OnlineLearning', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SE1827_SWP391_OnlineLearning.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SE1827_SWP391_OnlineLearning_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SE1827_SWP391_OnlineLearning_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SE1827_SWP391_OnlineLearning].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET ARITHABORT OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET  ENABLE_BROKER 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET RECOVERY FULL 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET  MULTI_USER 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'SE1827_SWP391_OnlineLearning', N'ON'
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET QUERY_STORE = OFF
GO
USE [SE1827_SWP391_OnlineLearning]
GO
/****** Object:  Table [dbo].[Administrator]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administrator](
	[administrator_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](255) NULL,
	[email] [nvarchar](255) NULL,
	[fullname] [nvarchar](100) NULL,
	[gender] [bit] NULL,
	[address] [nvarchar](255) NULL,
	[roles_id] [int] NULL,
	[imageUrl] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[administrator_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Answers]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answers](
	[answer_id] [int] IDENTITY(1,1) NOT NULL,
	[question_id] [int] NULL,
	[content] [text] NULL,
	[is_correct] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[answer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [varchar](255) NULL,
	[description] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Courses]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Courses](
	[course_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](255) NULL,
	[description] [text] NULL,
	[price] [decimal](10, 2) NULL,
	[duration] [int] NULL,
	[isActive] [bit] NULL,
	[imageUrl] [varchar](255) NULL,
	[category_id] [int] NULL,
	[administrator_id] [int] NULL,
	[rate] [int] NULL,
	[teacher_id] [int] NULL,
	[discount] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[course_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[customer_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](255) NULL,
	[fullname] [nvarchar](100) NULL,
	[email] [nvarchar](255) NULL,
	[phone] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[address] [nvarchar](255) NULL,
	[type] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Documents]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Documents](
	[document_id] [int] IDENTITY(1,1) NOT NULL,
	[course_id] [int] NULL,
	[title] [varchar](255) NULL,
	[description] [text] NULL,
	[document_url] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[document_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[customer_id] [int] NOT NULL,
	[course_id] [int] NOT NULL,
	[comment] [text] NULL,
	[rate] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC,
	[course_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[order_id] [int] NOT NULL,
	[course_id] [int] NOT NULL,
	[quantity] [int] NULL,
	[unitPrice] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC,
	[course_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[customer_id] [int] NULL,
	[order_date] [date] NULL,
	[total_amount] [decimal](10, 2) NULL,
	[payment] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Questions]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Questions](
	[question_id] [int] IDENTITY(1,1) NOT NULL,
	[quiz_id] [int] NULL,
	[content] [text] NULL,
	[correct_answer] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[question_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quizzes]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quizzes](
	[quiz_id] [int] IDENTITY(1,1) NOT NULL,
	[course_id] [int] NULL,
	[title] [varchar](255) NULL,
	[description] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[quiz_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[roles_id] [int] IDENTITY(1,1) NOT NULL,
	[roles_code] [varchar](255) NULL,
	[roles_name] [varchar](255) NULL,
	[description] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[roles_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teachers]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teachers](
	[teacher_id] [int] NOT NULL,
	[username] [varchar](50) NULL,
	[password] [varchar](100) NULL,
	[name] [varchar](100) NOT NULL,
	[gender] [bit] NULL,
	[email] [varchar](100) NULL,
	[phone] [varchar](50) NULL,
	[address] [varchar](100) NULL,
	[subject] [varchar](50) NULL,
	[imgUrl] [varchar](100) NULL,
	[join_date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[teacher_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Videos]    Script Date: 5/16/2024 4:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Videos](
	[video_id] [int] IDENTITY(1,1) NOT NULL,
	[course_id] [int] NULL,
	[title] [varchar](255) NULL,
	[description] [text] NULL,
	[video_url] [varchar](255) NULL,
	[duration] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[video_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Administrator] ON 

INSERT [dbo].[Administrator] ([administrator_id], [username], [password], [email], [fullname], [gender], [address], [roles_id], [imageUrl]) VALUES (1, N'danghoang', N'123', N'hoangndhe164015@fpt.edu.vn', N'Nguyen Dang Hoang', 1, N'Thanh Hoa', 1, NULL)
INSERT [dbo].[Administrator] ([administrator_id], [username], [password], [email], [fullname], [gender], [address], [roles_id], [imageUrl]) VALUES (2, N'dungnguyen', N'123', N'123', N'Nguyen Tuan Dung', 1, N'Ha Noi', 2, NULL)
INSERT [dbo].[Administrator] ([administrator_id], [username], [password], [email], [fullname], [gender], [address], [roles_id], [imageUrl]) VALUES (3, N'tanne', N'123', N'123', N'Doi Trong Tan', 1, N'Thanh Hoa', 3, NULL)
SET IDENTITY_INSERT [dbo].[Administrator] OFF
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([category_id], [category_name], [description]) VALUES (1, N'BackEnd', NULL)
INSERT [dbo].[Categories] ([category_id], [category_name], [description]) VALUES (2, N'FontEnd', NULL)
INSERT [dbo].[Categories] ([category_id], [category_name], [description]) VALUES (3, N'DataAnalys', NULL)
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Courses] ON 

INSERT [dbo].[Courses] ([course_id], [title], [description], [price], [duration], [isActive], [imageUrl], [category_id], [administrator_id], [rate], [teacher_id], [discount]) VALUES (1, N'Become a PHP Master and Make Money', N'Lorem ipsum dolor sit amet, est ei idque voluptua copiosae, pro detracto disputando reformidans at, ex vel suas eripuit. Vel alii zril maiorum ex, mea id sale eirmod epicurei. Sit te possit senserit, eam alia veritus maluisset ei, id cibo vocent ocurreret per. Te qui doming doctus referrentur, usu debet tamquam et. Sea ut nullam aperiam, mei cu tollit salutatus delicatissimi. ', CAST(190.00 AS Decimal(10, 2)), NULL, 0, N'assetsAdmin/images/courses/pic1.jpg', 1, 3, 3, NULL, NULL)
INSERT [dbo].[Courses] ([course_id], [title], [description], [price], [duration], [isActive], [imageUrl], [category_id], [administrator_id], [rate], [teacher_id], [discount]) VALUES (2, N'Data Analytics', N'– Intermediate IT students, colleges, universities in year 1,2,3 (with basic knowledge) ... want to learn methodically and improve practical skills aboJava Web
– Programmers are working in businesses that want to add knowledge and practical skills for work', CAST(150.00 AS Decimal(10, 2)), NULL, 1, N'assetsAdmin/images/courses/pic2.jpg', 1, 3, 3, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Courses] OFF
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([customer_id], [username], [password], [fullname], [email], [phone], [gender], [address], [type]) VALUES (1, N'nguyendanghoang', N'123', NULL, N'hoang@gmail.com', NULL, NULL, NULL, NULL)
INSERT [dbo].[Customer] ([customer_id], [username], [password], [fullname], [email], [phone], [gender], [address], [type]) VALUES (2, N'danghoang123', N'1', NULL, N'hoang@gmail.com', NULL, NULL, NULL, NULL)
INSERT [dbo].[Customer] ([customer_id], [username], [password], [fullname], [email], [phone], [gender], [address], [type]) VALUES (3, N'dungngu', N'123', NULL, N'dh694286@gmail.com', NULL, NULL, NULL, NULL)
INSERT [dbo].[Customer] ([customer_id], [username], [password], [fullname], [email], [phone], [gender], [address], [type]) VALUES (1002, N'danghoang1234', N'123', NULL, N'hoang@gmail.com', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([roles_id], [roles_code], [roles_name], [description]) VALUES (1, N'A1', N'Admin', N'Admin')
INSERT [dbo].[Roles] ([roles_id], [roles_code], [roles_name], [description]) VALUES (2, N'S2', N'Staff', N'Staff')
INSERT [dbo].[Roles] ([roles_id], [roles_code], [roles_name], [description]) VALUES (3, N'T3', N'Teacher', N'Teacher')
SET IDENTITY_INSERT [dbo].[Roles] OFF
GO
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (1, N'teacher1', N'password1', N'John Doe', 0, N'teacher1@example.com', N'123456789', N'123 Main St, City', N'Mathematics', N'teacher1.jpg', CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (2, N'teacher2', N'password2', N'Jane Smith', 1, N'teacher2@example.com', N'987654321', N'456 Elm St, Town', N'Science', N'teacher2.jpg', CAST(N'2024-02-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (3, N'teacher3', N'password3', N'David Johnson', 0, N'teacher3@example.com', N'555555555', N'789 Oak St, Village', N'History', N'teacher3.jpg', CAST(N'2024-03-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (4, N'teacher4', N'password4', N'Emily Brown', 1, N'teacher4@example.com', N'666666666', N'321 Pine St, County', N'English', N'teacher4.jpg', CAST(N'2024-04-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (5, N'teacher5', N'password5', N'Michael Wilson', 0, N'teacher5@example.com', N'777777777', N'654 Cedar St, Borough', N'Art', N'teacher5.jpg', CAST(N'2024-05-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (6, N'teacher6', N'password6', N'Sarah Martinez', 1, N'teacher6@example.com', N'888888888', N'987 Maple St, Township', N'Music', N'teacher6.jpg', CAST(N'2024-06-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (7, N'teacher7', N'password7', N'James Lee', 0, N'teacher7@example.com', N'999999999', N'741 Birch St, Parish', N'Physical Education', N'teacher7.jpg', CAST(N'2024-07-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (8, N'teacher8', N'password8', N'Amanda Taylor', 1, N'teacher8@example.com', N'111111111', N'852 Walnut St, District', N'Computer Science', N'teacher8.jpg', CAST(N'2024-08-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (9, N'teacher9', N'password9', N'Robert Anderson', 0, N'teacher9@example.com', N'222222222', N'963 Poplar St, Municipality', N'Geography', N'teacher9.jpg', CAST(N'2024-09-01' AS Date))
INSERT [dbo].[Teachers] ([teacher_id], [username], [password], [name], [gender], [email], [phone], [address], [subject], [imgUrl], [join_date]) VALUES (10, N'teacher10', N'password10', N'Laura Hernandez', 1, N'teacher10@example.com', N'333333333', N'147 Fir St, State', N'Foreign Language', N'teacher10.jpg', CAST(N'2024-10-01' AS Date))
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Teachers__AB6E616452E65AF6]    Script Date: 5/16/2024 4:58:51 PM ******/
ALTER TABLE [dbo].[Teachers] ADD UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Teachers__F3DBC572F5CE8A6C]    Script Date: 5/16/2024 4:58:51 PM ******/
ALTER TABLE [dbo].[Teachers] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Administrator]  WITH CHECK ADD FOREIGN KEY([roles_id])
REFERENCES [dbo].[Roles] ([roles_id])
GO
ALTER TABLE [dbo].[Answers]  WITH CHECK ADD FOREIGN KEY([question_id])
REFERENCES [dbo].[Questions] ([question_id])
GO
ALTER TABLE [dbo].[Courses]  WITH CHECK ADD FOREIGN KEY([administrator_id])
REFERENCES [dbo].[Administrator] ([administrator_id])
GO
ALTER TABLE [dbo].[Courses]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[Categories] ([category_id])
GO
ALTER TABLE [dbo].[Courses]  WITH CHECK ADD  CONSTRAINT [fk_department] FOREIGN KEY([teacher_id])
REFERENCES [dbo].[Teachers] ([teacher_id])
GO
ALTER TABLE [dbo].[Courses] CHECK CONSTRAINT [fk_department]
GO
ALTER TABLE [dbo].[Documents]  WITH CHECK ADD FOREIGN KEY([course_id])
REFERENCES [dbo].[Courses] ([course_id])
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([course_id])
REFERENCES [dbo].[Courses] ([course_id])
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([customer_id])
REFERENCES [dbo].[Customer] ([customer_id])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([course_id])
REFERENCES [dbo].[Courses] ([course_id])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[Orders] ([order_id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([customer_id])
REFERENCES [dbo].[Customer] ([customer_id])
GO
ALTER TABLE [dbo].[Questions]  WITH CHECK ADD FOREIGN KEY([quiz_id])
REFERENCES [dbo].[Quizzes] ([quiz_id])
GO
ALTER TABLE [dbo].[Quizzes]  WITH CHECK ADD FOREIGN KEY([course_id])
REFERENCES [dbo].[Courses] ([course_id])
GO
ALTER TABLE [dbo].[Videos]  WITH CHECK ADD FOREIGN KEY([course_id])
REFERENCES [dbo].[Courses] ([course_id])
GO
USE [master]
GO
ALTER DATABASE [SE1827_SWP391_OnlineLearning] SET  READ_WRITE 
GO
